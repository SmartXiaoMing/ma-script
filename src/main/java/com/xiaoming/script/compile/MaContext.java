package com.xiaoming.script.compile;

import com.xiaoming.script.utils.ObjectWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: xiaoming
 * @since: 2019-08-19
 */
public class MaContext {
    boolean parentReadOnly = false;
    MaContext parent = null;
    boolean isShadow = false;
    HashMap<String, Object> varMap = new HashMap<>();
    HashMap<Class, Class> rawWrapperMap;
    public static int FlowOrder = 0;
    public static int FlowContinue = 1;
    public static int FlowBreak = 2;
    public static int FlowReturn = 3;
    public static int FlowException = 4;
    int flowState = FlowOrder;

    public MaContext() {}
    public MaContext(MaContext parent) {
        this.parent = parent;
    }

    public Object define(String name, Object obj) {
        varMap.put(name, obj);
        return obj;
    }

    public Object set(String name, Object obj) {
        if (parent == null || parentReadOnly || varMap.containsKey(name)) {
            varMap.put(name, obj);
        } else {
            parent.set(name, obj);
        }
        return obj;
    }

    public Object get(String name) {
        Object r = varMap.get(name);
        if (r == null && parent != null ) {
            return parent.get(name);
        }
        if (r != null) {
            return r;
        }
        return null;
    }

    public boolean isDefined(String name) {
        if (varMap.containsKey(name)) {
            return true;
        }
        if (parent != null) {
            return parent.isDefined(name);
        }
        return false;
    }

    public MaContext getSub() {
        MaContext context = new MaContext(this);
        return context;
    }

    public MaContext getSandbox() {
        MaContext context = new MaContext(this);
        context.parentReadOnly = true;
        return context;
    }

    // 因为父作用域是访问不了子作用域的，因此这个方法是衍生一个平级作用域，会把varMap引入到当前作用域
    public MaContext shadowCopy() {
        MaContext context = new MaContext();
        context.parent = this.parent;
        context.parentReadOnly = this.parentReadOnly;
        context.rawWrapperMap = this.rawWrapperMap; // NOTE this should not be update, so assign it simply
        context.flowState = this.flowState;
        context.varMap = (HashMap<String, Object>) this.varMap.clone();
        context.isShadow = true;
        return context;
    }

    public void addClassWrapper(Class raw, Class<? extends ObjectWrapper> wrapper) {
        if (rawWrapperMap == null) {
            rawWrapperMap = new HashMap<>();
        }
        rawWrapperMap.put(raw, wrapper);
    }

    public ObjectWrapper getObjectWrapper(Object objectRaw) { // objRaw should not be null
        Class raw = objectRaw.getClass();
        return getClassObjectWrapper(raw, objectRaw);
    }

    public ObjectWrapper getClassObjectWrapper(Class raw, Object objectRaw) { // objRaw should not be null
        if (rawWrapperMap != null) {
            Class wrapper = rawWrapperMap.get(raw);
            if (wrapper != null) {
                try {
                    ObjectWrapper objectWrapper = (ObjectWrapper) wrapper.newInstance();
                    objectWrapper._wrap(objectRaw);
                    return objectWrapper;
                } catch (Exception e) {
                    throw new RuntimeException("invalid ObjectWrapper class: " + wrapper.getName(), e);
                }
            }
        }
        if (parent != null) {
            return parent.getClassObjectWrapper(raw, objectRaw);
        }
        return null;
    }

    void printTree() {
        StringBuilder sb = new StringBuilder();
        MaContext context = this;
        int level = 0;
        while (context != null) {
            sb.append(level).append(": ");
            ++level;
            for (Map.Entry<String, Object> entry : context.varMap.entrySet()) {
                sb.append(entry.getKey()).append(" = ").append(String.valueOf(entry.getValue())).append(", ");
            }
            sb.append("\n");

            context = context.parent;
        }
        System.out.print(sb.toString());
    }

    public List<String> getDefNameList() {
        List<String> list = new ArrayList<>();
        for (String key : varMap.keySet()) {
            list.add(key);
        }
        if (parent != null) {
            list.addAll(parent.getDefNameList());
        }
        return list;
    }
}
