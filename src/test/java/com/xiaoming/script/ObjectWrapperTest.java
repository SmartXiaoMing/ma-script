package com.xiaoming.script;

import com.xiaoming.script.compile.MaCompileOptions;
import com.xiaoming.script.compile.MaCompileResult;
import com.xiaoming.script.compile.MaContext;
import com.xiaoming.script.compile.MaScript;
import com.xiaoming.script.utils.ObjectWrapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xiaoming
 * @since: 2019-08-20
 */
public class ObjectWrapperTest {
    public static class Raw {
        public int[] array = new int[] {0, 1, 2, 3, 4, 5, 6};
        public Map<String, String> map = new HashMap<>();
        public int rank = 10;
        public void bigRank() {
            rank = 999;
        }
        public int getRank() {
            return rank;
        }
        public String some() {
            return "123";
        }
    }

    public static class RawWrapper implements ObjectWrapper {
        public Raw raw;
        @Override
        public void _wrap(Object obj) {
            this.raw = (Raw) obj;
        }

        public void _setIndex(int i, int value) {
            raw.array[i] = value;
        }

        public int _getIndex(int i) {
            return raw.array[i];
        }

        public void _setMember(String key, String value) {
            raw.map.put(key, value);
        }

        public String _getMember(String key) {
            if (key.equals("some")) {
                return raw.some();
            } else {
                return raw.map.get(key);
            }
        }

        public void resetRank() {
            raw.rank = 0;
        }
    }

    @Test
    public void testWrapper() {
        MaContext context = new MaContext();
        context.addClassWrapper(Raw.class, RawWrapper.class);
        Raw raw = new Raw();
        context.define("raw", raw);
        /*Assert.assertEquals(run(context, "raw[1] = 10; raw[1]"), String.valueOf(raw.array[1]));
        Assert.assertEquals(run(context, "raw.name = 'xiaoming'; raw.name"), String.valueOf(raw.map.get("name")));
        Assert.assertEquals(run(context, "raw.rank"), "null"); // shadow
        Assert.assertEquals(run(context, "raw.resetRank(); raw.getRank()"), "0");
        Assert.assertEquals(run(context, "raw.bigRank(); raw.getRank()"), "999");*/
        Assert.assertEquals(run(context, "raw.some; "), "123");
        //Assert.assertEquals(run(context, "raw.some(); "), "123");
    }

    static String run(MaContext context, String text) {
        return run(context, text, null);
    }

    static String run(MaContext context, String text, MaCompileOptions options) {
        MaScript maScript = new MaScript();
        maScript.setCompileOptions(options);
        class Console {
            public void log(Object obj) {
                System.out.println(String.valueOf(obj));
            }
        }
        context.set("console", new Console());
        MaCompileResult compileResult = maScript.compile(text);
        if (compileResult.error != 0) {
            System.out.println("errorMsg: " + compileResult.message);
            return compileResult.message;
        }
        return String.valueOf(maScript.run(context));
    }

    static String run(String text) {
        MaContext context = new MaContext();
        class Console {
            public void log(Object obj) {
                System.out.println(String.valueOf(obj));
            }
        }
        context.set("Console", new Console());
        return run(context, text);
    }

    public static String sampleFunc(String p1, int p2, boolean p3, byte p4, float p5) {
        return p1 + p2 + p3 + p4 + p5;
    }

}
