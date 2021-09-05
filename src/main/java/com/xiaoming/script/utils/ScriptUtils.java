package com.xiaoming.script.utils;

public class ScriptUtils {
    public static boolean isTrue(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Boolean) {
            return (Boolean)obj;
        }
        if (obj instanceof Number) {
            return ((Number) obj).intValue() != 0;
        }
        if (obj instanceof String) {
            return "True".equalsIgnoreCase((String) obj);
        }
        return true;
    }

    public static String aSExpr(String src) {
        return "s`" + src + "`";
    }
}
