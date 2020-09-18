package com.xiaoming.script.compile;

/**
 * @author: xiaoming
 * @since: 2019-09-17
 */
public class MaCompileResult {
    public int error = 0;
    public int warn = 0;
    public String message = "";

    @Override
    public String toString() {
        return "MaCompileResult{" +
                "error=" + error +
                ", warn=" + warn +
                ", message='" + message + '\'' +
                '}';
    }
}
