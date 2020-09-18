package com.xiaoming.script.compile;

/**
 * @author: xiaoming
 * @since: 2019-08-21
 */
public interface Evaluable {
    Object eval(MaContext runtime);
    Evaluable Null = runtime -> null;
    Evaluable True = runtime -> true;
    Evaluable False = runtime -> false;
    Evaluable Zero = runtime -> 0;
    static Evaluable get(Object obj) {
        return runtime -> obj;
    }
}
