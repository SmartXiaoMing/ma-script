package com.xiaoming.script;

import com.xiaoming.script.compile.MaCompileOptions;
import com.xiaoming.script.compile.MaCompileResult;
import com.xiaoming.script.compile.MaContext;
import com.xiaoming.script.compile.MaScript;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Locale;

/**
 * @author: xiaoming
 * @since: 2019-08-20
 */
public class ScriptTest {

    @Test
    public void testOperatorExpr() {
        Assert.assertEquals(run("1+1"), "2");
        Assert.assertEquals(run("1+1.0"), "2.0");
        Assert.assertEquals(run("100 - 64"), "36");
        Assert.assertEquals(run("100.25 - 64"), "36.25");
        Assert.assertEquals(run("1<2"), "true");
        Assert.assertEquals(run("1<=2"), "true");
        Assert.assertEquals(run("1>2"), "false");
        Assert.assertEquals(run("1>=2"), "false");
        Assert.assertEquals(run("1<2.1"), "true");
        Assert.assertEquals(run("1<=2.1"), "true");
        Assert.assertEquals(run("1>2.1"), "false");
        Assert.assertEquals(run("1>=2.1"), "false");
        Assert.assertEquals(run("1 && 2"), "true");
        Assert.assertEquals(run("1 && 0"), "false");
        Assert.assertEquals(run("1 && true"), "true");
        Assert.assertEquals(run("1 && false"), "false");
        Assert.assertEquals(run("1 & 2"), "true");
        Assert.assertEquals(run("1 & 0"), "false");
        Assert.assertEquals(run("1 & true"), "true");
        Assert.assertEquals(run("1 & false"), "false");
        Assert.assertEquals(run("0 | 2"), "true");
        Assert.assertEquals(run("0 | 0"), "false");
        Assert.assertEquals(run("0 | true"), "true");
        Assert.assertEquals(run("0 | false"), "false");
        Assert.assertEquals(run("0 || 2"), "true");
        Assert.assertEquals(run("0 || 0"), "false");
        Assert.assertEquals(run("0 || true"), "true");
        Assert.assertEquals(run("0 || false"), "false");
        Assert.assertEquals(run("!0;"), "true");
        Assert.assertEquals(run("!!0;"), "false");
        Assert.assertEquals(run("!!!0;"), "true");
        Assert.assertEquals(run("!false;"), "true");
        Assert.assertEquals(run("!!false;"), "false");
        Assert.assertEquals(run("!!!false;"), "true");
        Assert.assertEquals(run("!null;"), "true");
        Assert.assertEquals(run("!!null;"), "false");
        Assert.assertEquals(run("!!!null;"), "true");
        Assert.assertEquals(run("!true;"), "false");
        Assert.assertEquals(run("!!true;"), "true");
        Assert.assertEquals(run("!!!true;"), "false");
        Assert.assertEquals(run("!1;"), "false");
        Assert.assertEquals(run("!!1;"), "true");
        Assert.assertEquals(run("!!!1;"), "false");

        Assert.assertEquals(run("var a = 10; a > 10 && 2 > 1"), "false");
        Assert.assertEquals(run("var a = 10; a >= 10 && 2 > 1"), "true");
        Assert.assertEquals(run("var a = 10; a > 10 && 2 < 1"), "false");
        Assert.assertEquals(run("var a = 10; a >= 10 && 2 < 1"), "false");
        Assert.assertEquals(run("var a = 10; a > 10 || 2 > 1"), "true");
        Assert.assertEquals(run("var a = 10; a >= 10 || 2 < 1"), "true");
        Assert.assertEquals(run("var a = 10; a > 10 || 2 > 1"), "true");
        Assert.assertEquals(run("var a = 10; a >= 10 || 2 < 1"), "true");

        Assert.assertEquals(run("0 || 2"), "true");

        Assert.assertEquals(run("1+1;"), "2");
        Assert.assertEquals(run("3-1;"), "2");
        Assert.assertEquals(run("1+2*3;"), "7");
        Assert.assertEquals(run("1*2+3;"), "5");
        Assert.assertEquals(run("1-2/3;"), "1");
        Assert.assertEquals(run("1/2-3;"), "-3");
        Assert.assertEquals(run("var i = 10; ++i;"), "11");
        Assert.assertEquals(run("var i = 10; i++;"), "11");
        Assert.assertEquals(run("var i = 10; --i;"), "9");
        Assert.assertEquals(run("var i = 10; i--;"), "9");

        Assert.assertEquals(run("'hello' ~= 'hello'"), "true");
        Assert.assertEquals(run("'hello' ~= 'helle'"), "false");
        Assert.assertEquals(run("'hello' ~= 'hell.*'"), "true");
        Assert.assertEquals(run("'hello' ~= 'hell[0-9]'"), "false");
        Assert.assertEquals(run("'123' ~= '[0-9][0-9][0-9]'"), "true");
        Assert.assertEquals(run("'123' ~= '[0-9][0-9][0-9][0-9]'"), "false");
        Assert.assertEquals(run("'goodmorning' ~= 'good.*ing'"), "true");
        Assert.assertEquals(run("'goodmorning' ~= '^good.*ing'"), "true");
        Assert.assertEquals(run("'1goodmorning' ~= '^good.*ing'"), "false");
        Assert.assertEquals(run("'goodmorning' ~= '^good.*ing$'"), "true");
    }

    @Test
    public void testIfExpr() {
        Assert.assertEquals(run("if (1+1==2) 123; else 2+8;"), "123");
        Assert.assertEquals(run("if (1+1!=2) 123; else 2 + 8;"), "10");
        Assert.assertEquals(run("if (1+1==2) { var s = 2 + 3;} else {var d = 99;}"), "5");
        Assert.assertEquals(run("if (1+1!=2) { var s = 2 + 3;} else {var d = 99;}"), "99");
        Assert.assertEquals(run("if (1+1!=2) { var s = 2 + 3;} else if (true) {var d = 99;}"), "99");
        Assert.assertEquals(run("if (1+1!=2) { var s = 2 + 3;} else if (false) {var d = 99;} else 123"), "123");
    }

    @Test
    public void testFunctionExpr() {
        Assert.assertEquals(run("function add(a, b) { return a + b; } add(1, 2);"), "3");
        Assert.assertEquals(run("function f(n) { n <= 1 ? 1 : f(n-1) + f(n-2); } f(0);"), "1");
        Assert.assertEquals(run("function f(n) { n <= 1 ? 1 : f(n-1) + f(n-2); } f(1);"), "1");
        Assert.assertEquals(run("function f(n) { n <= 1 ? 1 : f(n-1) + f(n-2); } f(2);"), "2");
        Assert.assertEquals(run("function f(n) { n <= 1 ? 1 : f(n-1) + f(n-2); } f(3);"), "3");
        Assert.assertEquals(run("function f(n) { var r = (n <= 1 ? 1 : f(n-1) + f(n-2)); log(\"f\"+n+\"=\"+r); r;} f(4); "), "5");
        Assert.assertEquals(run("function f(n) { n <= 1 ? 1 : f(n-1) + f(n-2); } f(5);"), "8");
    }

    @Test
    public void testForItStat() {
        Assert.assertEquals(run("for (var i = 0; i <= 10; i=i+1) { i * i; }"), "100");
        Assert.assertEquals(run("for (var i = 0; i < 10; i = i + 1) { if (i == 5) break 99; }"), "99");
    }

    @Test
    public void testForInStat() {
        Assert.assertEquals(run("for (i : [1, 2, 3, 4, 5]) { i * i; }"), "25");
        Assert.assertEquals(run("for (i : [1, 2, 3, 4, 5]) { if (i == 2) break 989; }"), "989");
    }

    @Test
    public void testReturnBreakStat() {
        Assert.assertEquals(run("function f(){for (i : [1, 2]) { return 2; break 1; }} f()"), "2");
        Assert.assertEquals(run("function f(){for (i : [1, 2]) { break 1; } return 2; } f()"), "2");
    }

    enum EnumValue {
        Good("g", 0),
        Bad("b", 1),
        ;
        EnumValue(String name, int code) {
            this.name = name;
            this.code = code;
        }
        public final String name;
        int code;
        public int getCode() {
            return code;
        }
    }

    @Test
    public void testEnum() {
        MaContext context = new MaContext();
        context.define("EnumValue", EnumValue.class);
        context.define("bad", EnumValue.Bad);
        Assert.assertEquals(run(context, "EnumValue.Good.name"), "g");
        Assert.assertEquals(run(context, "EnumValue.Good.getCode"), "0");
        Assert.assertEquals(run(context, "EnumValue.Good.ordinal()"), "0");
        Assert.assertEquals(run(context, "EnumValue.Good.name()"), "Good");
        // Assert.assertEquals(run(context, "EnumValue.values().length"), "2");
        Assert.assertEquals(run(context, "bad.name"), "b");
        Assert.assertEquals(run(context, "bad.name()"), "Bad");
        Assert.assertEquals(run(context, "bad.getCode"), "1");
        Assert.assertEquals(run(context, "bad.ordinal"), "1");
    }

    @Test
    public void testClosure() {
        String src =
                " function f() {\n" +
                "  var t = 10; " +
                "  return function ff () { " +
                "   t += 1; " +
                "   Console.log('t = ' + t);" +
                "   return t;" +
                "  }" +
                " }" +
                " t = 100;" +
                " var t = f();" +
                " t();t();";
        Assert.assertEquals(run(src), "12");
    }

    @Test
    public void testLambda() {
        Assert.assertEquals(run("var f = (n) -> n*n; f(10);"), "100");
        Assert.assertEquals(run("var f = (n) -> n*n; f(8);"), "64");
        Assert.assertEquals(run("var f = (n) -> n*n; f(-1);"), "1");
        Assert.assertEquals(run("var f = n -> n*n; f(10);"), "100");
        Assert.assertEquals(run("var f = n -> n*n; f(8);"), "64");
        Assert.assertEquals(run("var f = n -> n*n; f(-1);"), "1");
        Assert.assertEquals(run("var f = (a, b) -> {a + b;}; f(1, 1);"), "2");
        Assert.assertEquals(run("var f = (a, b) -> {a + b;}; f(9, 1);"), "10");
        Assert.assertEquals(run("var n = 1; var f = () -> {n+=1; n*n;}; f();"), "4");
        Assert.assertEquals(run("var n = 1; var f = () -> {n+=1; n*n;}; f();f();"), "9");
    }

    @Test
    public void testVaryMethod() {
        MaContext context = new MaContext();
        context.define("String", String.class);
        context.define("Locale", Locale.class);
        context.define("haha", this.getClass());
        Assert.assertEquals(run(context, "String.format(Locale.CHINA, '%.2f,%04d,%s', 1.234, 1, 'str')"), "1.23,0001,str");
        Assert.assertEquals(run(context, "String.format('%.2f,%04d,%s', 1.234, 1, 'str')"), "1.23,0001,str");
    }

    @Test
    public void testForSpeed() {
        int n = 100000;
        String src = "var j = 0; for (var i = 0; i < " + n + "; i++) { j = i + 100; } return j;";
        MaScript maScript = new MaScript();
        MaContext context = new MaContext();
        MaCompileResult compileResult = maScript.compile(src);
        long s1 = System.currentTimeMillis();
        maScript.run(context);
        long s2 = System.currentTimeMillis();
        Integer j = 0;
        for (Integer i = 0; i < n; ++i) {
            j = i  + 100;
        }
        j += 1;
        long s3 = System.currentTimeMillis();
        System.out.println("test for-loop " + n + " times, java cost: " + (s3 - s2) + ", script cost: " + (s2 - s1));
    }

    @Test
    public void testInject() {
        MaContext context = new MaContext();
        String str = "123456789";
        context.define("String", "");
        context.define("str", str);
        context.define("ScriptTest", new ScriptTest());
        Assert.assertEquals(run(context, "String.valueOf('123');"), "123");
        Assert.assertEquals(run(context, "String.valueOf('123.1');"), "123.1");
        // Assert.assertEquals(run(context, "String.format('%02d-%02d-%02d', 2019, 6, 6);"), "20190606");
        Assert.assertEquals(run(context, "str.substring(1);"), str.substring(1));
        Assert.assertEquals(run(context, "str.substring(2, 3);"), str.substring(2, 3));
        Assert.assertEquals(run(context, "str.length();"), String.valueOf(str.length()));
        Assert.assertEquals(run(context, "str.length();"), String.valueOf(str.length()));
        Assert.assertEquals(run(context, "ScriptTest.sampleFunc('1', 2, true, 4, 5);"),
                ScriptTest.sampleFunc("1", 2, true, (byte) 4, 5));
    }

    @Test
    public void testStats() {
        HashMap<String, String> map = new HashMap<>();
        MaContext context = new MaContext();
        String str = "123456789";
        context.define("String", "");
        context.define("str", str);
        context.define("map", map);
        Assert.assertEquals(run(context,
                "String.valueOf('123'); var s = str; var a = s.length(); console.log(a*100);return a * 100; "),
                String.valueOf(str.length() * 100));
        String blockStats1 = "map.put('name', 'hello');" +
                "if (map.containsKey('name')) { map.put('value', 'xiaoming'); }" +
                "if (map.containsKey('value')) { map.put('result', 'xiaodan'); }" +
                "var r = map.get('result');" +
                "console.log(r);" +
                "return r;";
        String blockStats2 = "{map.put('name', 'hello');" +
                "if (map.containsKey('name')) { map.put('value', 'xiaoming'); }" +
                "if (map.containsKey('value')) { map.put('result', 'xiaodan'); }" +
                "var r = map.get('result');" +
                "console.log(r);" +
                "return r;}";
        Assert.assertEquals(run(context, blockStats1), "xiaodan");
        Assert.assertEquals(run(context, blockStats2), "xiaodan");
    }

    @Test
    public void testStringFormat() {
        HashMap<String, String> map = new HashMap<>();
        MaContext context = new MaContext();
        String str = "123456789";
        context.define("String", "");
        context.define("str", str);
        context.define("map", map);
        Assert.assertEquals(run(context, "s\"hello$str!\""), "hello" + str + "!");
        Assert.assertEquals(run(context, "s\"hello${55 * 55}!$str.haha\""), "hello" + (55 * 55) + "!" + str + ".haha");
        Assert.assertEquals(run(context, "map.put('name', 'xiaoming');s\"hello${map.get('name')}!\""),
                "hello" + map.get("name") + "!");
        Assert.assertEquals(run(context, "s\"${\"\"}\""), "");
    }

    @Test
    public void testBackStringFormat() {
        HashMap<String, String> map = new HashMap<>();
        MaContext context = new MaContext();
        String str = "123456789";
        context.define("String", "");
        context.define("str", str);
        context.define("map", map);
        Assert.assertEquals(run(context, "s`123`"), "123");
        Assert.assertEquals(run(context, "s`1\"\"2\"3`"), "1\"\"2\"3");
        Assert.assertEquals(run(context, "s`1\"\"\"3`"), "1\"\"\"3");
        Assert.assertEquals(run(context, "s`1'''3`"), "1'''3");
        Assert.assertEquals(run(context, "s`1''\\`'3`"), "1''`'3");
        Assert.assertEquals(run(context, "s`hello$str!`"), "hello" + str + "!");
        Assert.assertEquals(run(context, "s`hello${55 * 55}!$str.haha`"), "hello" + (55 * 55) + "!" + str + ".haha");
        Assert.assertEquals(run(context, "map.put('name', 'xiaoming');s`hello${map.get('name')}!`"),
                "hello" + map.get("name") + "!");
        Assert.assertEquals(run(context, "s`${\"\"}`"), "");
    }

    @Test
    public void testBackStringSquareFunction() {
        HashMap<String, String> map = new HashMap<>();
        MaCompileOptions options = new MaCompileOptions();
        MaContext context = new MaContext();
        String src1 = "s`好的，[礼貌用语]，为你播放刘德华的歌曲`";
        Assert.assertEquals(run(new MaContext(), src1, options), "好的，[礼貌用语]，为你播放刘德华的歌曲");
        String src2 = "function _square(text) {return '你真有礼貌';} s`好的，[礼貌用语]，为你播放刘德华的歌曲`";
        Assert.assertEquals(run(new MaContext(), src2, options), "好的，你真有礼貌，为你播放刘德华的歌曲");
        String src3 = "function _foo(text) {return '你真有礼貌';} s`好的，[礼貌用语]，为你播放刘德华的歌曲`";
        Assert.assertEquals(run(new MaContext(), src3, options), "好的，[礼貌用语]，为你播放刘德华的歌曲");
        options.squareFunctionName = "_foo";
        Assert.assertEquals(run(new MaContext(), src3, options), "好的，你真有礼貌，为你播放刘德华的歌曲");
    }

    @Test
    public void testAssignAsEq() {
        MaContext context = new MaContext();
        context.define("value", true);
        MaCompileOptions maCompileOptions = new MaCompileOptions();
        maCompileOptions.assignAsEq = true;
        Assert.assertEquals(run(context, "value=false"), "false");
        Assert.assertEquals(run(context, "value=true"), "true");
        Assert.assertEquals(run(context, "value"), "true");
        Assert.assertEquals(run(context, "value=true&&false", maCompileOptions), "false");
        Assert.assertEquals(run(context, "value=false&&true", maCompileOptions), "false");
        Assert.assertEquals(run(context, "false&&false=false", maCompileOptions), "false");
        Assert.assertEquals(run("1=2"), "false");
        Assert.assertEquals(run("1+9=10"), "true");
        Assert.assertEquals(run("1*9=10"), "false");
    }

    @Test
    public void testRegex() {
        MaContext context = new MaContext();
        MaCompileOptions options = new MaCompileOptions();
        options.assignAsEq = true;
        Assert.assertEquals(run(context,"'粤语&粤剧'~='.*?(歌|曲|剧|乐).*?'", options), "true");
        Assert.assertEquals(run(context,"var result = false; result == false && '粤语&粤剧'~='.*?(歌|曲|剧|乐).*?'", options), "true");
    }

    @Test
    public void testProgramReturn() {
        Assert.assertEquals(run("return 1; return 2;"), "1");
        Assert.assertEquals(run("1+1; return 2;"), "2");
    }

    @Test
    public void testInnerClass() {
        MaContext context = new MaContext();
        context.define("System", System.class);
        context.define("Math", Math.class);
        Assert.assertEquals(run(context, "System.currentTimeMillis()"), String.valueOf(System.currentTimeMillis()));
        Assert.assertEquals(run(context, "Math.abs(-1)"), "1");
    }

    @Test
    public void testArray() {
        MaContext context = new MaContext();
        Assert.assertEquals(run(context, "'1,2,3'.split(',').length"), "3");
        Assert.assertEquals(run(context, "'1,22,3'.split(',')[1]"), "22");
        Assert.assertEquals(run(context, "'1,22,3'.split(',')[1].length()"), "2");
    }

    @Test
    public void testUnderlyingMethod() {
        MaContext context = new MaContext();
        String src = "function __size() { return 0; } function __get(self) {return self;}";
        /*Assert.assertEquals(run(context, src + "null.size"), "0");
        Assert.assertEquals(run(context, src + "null.size()"), "0");
        Assert.assertEquals(run(context, src + "null.size(123)"), "0");

        Assert.assertEquals(run(context, src + "null.get"), "null");*/
        Assert.assertEquals(run(context, src + "null.get()"), "null"); /*
        Assert.assertEquals(run(context, src + "null.get(123)"), "null");

        Assert.assertEquals(run(context, src + "1.get"), "1");
        Assert.assertEquals(run(context, src + "1.get()"), "1");
        Assert.assertEquals(run(context, src + "1.get(123)"), "1");*/
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
