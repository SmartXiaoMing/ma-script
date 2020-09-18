package com.xiaoming.script;

import com.xiaoming.script.compile.MaCompileOptions;
import com.xiaoming.script.compile.MaCompileResult;
import com.xiaoming.script.compile.MaContext;
import com.xiaoming.script.compile.MaScript;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author: xiaoming
 * @since: 2019-08-20
 */
public class NoParamMethodTest {
    public static class Person {
        public int age = 20;
        public String gender() {
            return "male";
        }
    }

    @Test
    public void testWrapper() {
        MaContext context = new MaContext();
        context.define("person", new Person());
        Assert.assertEquals(run(context, "person.age; "), "20");
        Assert.assertEquals(run(context, "person.gender; "), "male");
        Assert.assertEquals(run(context, "person.gender(); "), "male");
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
}
