package com.xiaoming.script.compile;

/**
 * @author: xiaoming
 * @since: 2019-11-12
 */
public class MaCompileOptions {
    public static boolean assignAsEqDefault = false; // treat '=' as '=='
    public static boolean nullDotDefault = true;
    public static boolean nullIndexDefault = false;
    public static String squareFunctionNameDefault = "_square"; // [] function name


    public boolean assignAsEq = assignAsEqDefault; // treat '=' as '=='
    public boolean nullDot = nullDotDefault;
    public boolean nullIndex = nullIndexDefault;
    public String squareFunctionName = squareFunctionNameDefault; // [] function name

    public static boolean getNullDot(MaCompileOptions options) {
        return options != null ? options.nullDot : nullDotDefault;
    }
}
