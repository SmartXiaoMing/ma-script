package com.xiaoming.script;

import com.xiaoming.script.compile.MaContext;
import com.xiaoming.script.compile.MaScript;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: xiaoming
 * @since: 2019-08-20
 */
public class MultiThreadTest {
    public static HashMap<String, String> newMap() {
        return new HashMap<>();
    }

    public static List<String> newList() {
        return new ArrayList<String>();
    }

    @Test
    public void testFunction() throws InterruptedException {
        MaContext context = new MaContext();
        context.define("System", System.class);
        context.define("Utils", this.getClass());
        String lib = "function getDay (i) {" +
                "var list = Utils.newList();" +
                "list.add('7');" +
                "list.add('1');" +
                "list.add('2');" +
                "list.add('3');" +
                "list.add('4');" +
                "list.add('5');" +
                "list.add('6');" +
                "return list.get(i);" +
                "}";
        MaScript libScript = new MaScript();
        libScript.compile(lib);
        libScript.run(context);
        String main = "return 'the day is ' + getDay(d) + ', good luck!';";
        MaScript mainScript = new MaScript();
        mainScript.compile(main);
        int threadCount = 100;
        Thread[] t = new Thread[threadCount];
        for (int i = 0; i < threadCount; ++i) {
            final int d = i % 7;
            final int expectedValue = d == 0 ? 7 : d;
            t[i] = new Thread(() -> {
                MaContext sandbox = context.getSandbox();
                sandbox.define("d", d);
                String runResult = (String) mainScript.run(sandbox);
                Assert.assertEquals(runResult, "the day is " + expectedValue + ", good luck!");
            });
            t[i].start();
        }
        for (int i = 0; i < threadCount; ++i) {
            t[i].join();
        }
    }
}
