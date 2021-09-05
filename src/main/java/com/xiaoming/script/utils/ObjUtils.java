package com.xiaoming.script.utils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: xiaoming
 * @since: 2019-08-26
 */
public class ObjUtils {
    public static final Object NotFound = new Object();
    public static Class[] classLevel = new Class[] {
            null, // 0
            Boolean.class, Boolean.TYPE, // 2
            Byte.class, Byte.TYPE, Short.class, Short.TYPE, Integer.class, Integer.TYPE, Long.class, Long.TYPE, // 10
            Float.class, Float.TYPE, Double.class, Double.TYPE,  // 14
            String.class // 15
    };

    public static int getClassLevel(Object v) {
        if (v == null) {
            return 0;
        }
        for (int i = 1; i < classLevel.length; ++i) {
            if (classLevel[i].isInstance(v)) {
                return i;
            }
        }
        return classLevel.length; // 16
    }

    public static int compare(Object v1, Object v2) {
        if (v1 == v2) {
            return 0;
        }
        if (v1 == null) {
            return -1;
        }
        if (v2 == null) {
            return 1;
        }
        if (v1.getClass() == v2.getClass()) {
            if (v1 instanceof Comparable) {
                return ((Comparable) v1).compareTo(v2);
            }
            return 0;
        }
        if (v1 instanceof Number && v2 instanceof Number) {
            double d = ((Number) v1).doubleValue() - ((Number) v2).doubleValue();
            return d < 0 ? - 1 : (d == 0 ? 0 : 1);
        }
        if (v2 instanceof String) {
            return String.valueOf(v1).compareTo((String) v2);
        }
        return v1.getClass().getName().compareTo(v2.getClass().getName());
    }

    public static boolean like(Object v1, Object v2) {
        String s1 = String.valueOf(v1);
        String s2 = String.valueOf(v2);
        return s1.matches(s2);
    }

    public static boolean equals(Object v1, Object v2) {
        if (v1 == v2) {
            return true;
        }
        if (v1 == null || v2 == null) {
            return false;
        }
        if (v1.getClass() == v2.getClass()) {
            return v1.equals(v2);
        }
        if (v1 instanceof Number && v2 instanceof Number) {
            return ((Number) v1).doubleValue() == ((Number) v2).doubleValue();
        }
        return false;
    }

    public static Object cast(Object v, Class targetObj) {
        if (v == null) {
            return null; // TODO maybe bool?
        }
        //System.out.println("v = " + v + ", v.class = " + v.getClass().getTypeName() +
        //        ", target = " + targetObj + ", target.class =" + targetObj.getClass().getTypeName());
        if (targetObj.isInstance(v)) {
            return v;
        }
        if (targetObj == Double.class || targetObj == Double.TYPE) {
            if (v instanceof Number) {
                return ((Number) v).doubleValue();
            }
            return new Double(0.0);
        }
        if (targetObj == Float.class || targetObj == Float.TYPE) {
            if (v instanceof Number) {
                return ((Number) v).floatValue();
            }
            return new Float(0.0);
        }
        if (targetObj == Long.class || targetObj == Long.TYPE) {
            if (v instanceof Number) {
                return ((Number) v).longValue();
            }
            return new Long(0);
        }
        if (targetObj == Integer.class || targetObj == Integer.TYPE) {
            if (v instanceof Number) {
                return ((Number) v).intValue();
            }
            return new Integer(0);
        }
        if (targetObj == Short.class || targetObj == Short.TYPE) {
            if (v instanceof Number) {
                return ((Number) v).shortValue();
            }
            return new Short((short) 0);
        }
        if (targetObj == Byte.class || targetObj == Byte.TYPE) {
            if (v instanceof Number) {
                return ((Number) v).byteValue();
            }
            return new Byte((byte) 0);
        }
        if (targetObj == Boolean.class || targetObj == Boolean.TYPE) {
            if (v instanceof Number) {
                return ((Number) v).intValue() == 0;
            } else if (v instanceof String) {
                return ((String) v).isEmpty();
            }
            return true;
        }
        if (targetObj == String.class) {
            return String.valueOf(v);
        }
        return null;
    }

    public static Object castNumber(Object v, Class targetObj) {
        if (targetObj.isInstance(v)) {
            return v;
        }
        if (targetObj == Double.class || targetObj == Double.TYPE) {
            return ((Number) v).doubleValue();
        }
        if (targetObj == Float.class || targetObj == Float.TYPE) {
            return ((Number) v).floatValue();
        }
        if (targetObj == Long.class || targetObj == Long.TYPE) {
            return ((Number) v).longValue();
        }
        if (targetObj == Integer.class || targetObj == Integer.TYPE) {
            return ((Number) v).intValue();
        }
        if (targetObj == Short.class || targetObj == Short.TYPE) {
            return ((Number) v).shortValue();
        }
        if (targetObj == Byte.class || targetObj == Byte.TYPE) {
            return ((Number) v).byteValue();
        }
        return v;
    }

    public static Object getMember(Object obj, String name) {
        try {
            boolean isClass = obj instanceof Class<?>;
            Class<?> clazz = isClass ? (Class<?>) obj : obj.getClass();
            if (isClass && clazz.isEnum()) { // check enum first
                for (Enum e : (Enum[]) clazz.getEnumConstants()) {
                    if (e.name().equals(name)) {
                        return e;
                    }
                }
            }
            Field[] fields = clazz.getDeclaredFields(); // private and public
            if (fields != null) {
                for (Field f : fields) {
                    if (f.getName().equals(name)) {
                        f.setAccessible(true);
                        return f.get(obj);
                    }
                }
            }
            fields = clazz.getFields(); // this and super
            if (fields != null) {
                for (Field f : fields) {
                    if (f.getName().equals(name)) {
                        f.setAccessible(true);
                        return f.get(obj);
                    }
                }
            }
            // to find method without param
            Method[] method = clazz.getMethods();
            if (method != null) {
                for (Method m : method) {
                    if (m.getParameterCount() == 0 && m.getName().equals(name)) {
                        m.setAccessible(true);
                        return m.invoke(obj, null);
                    }
                }
            }
            if (name.equals("length") && obj.getClass().isArray()) { // for array.length
                if (obj != null && obj.getClass().isArray()) {
                    return Array.getLength(obj);
                }
            }
            return ObjUtils.NotFound;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("illegal to access field: " + name + ", class: " + obj.getClass().getName(), e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException("illegal to call field: " + name + ", class: " + obj.getClass().getName(), e);
        }
    }

    public static void setMember(Object obj, String name, Object value) {
        try {
            if (obj == null) {
                throw new RuntimeException("no field: " + name + " for null");
            }
            Class<?> clazz = obj instanceof Class<?> ? (Class<?>) obj : obj.getClass();
            Field f = clazz.getDeclaredField(name); // TODO NPE?
            f.setAccessible(true);
            Object castValue = cast(value, f.getType());
            f.set(obj, castValue);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("no field: " + name + ", class: " + obj.getClass().getName(), e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("illegal to access field: " + name + ", class: " + obj.getClass().getName(), e);
        }
    }

    public static boolean isNumberClass(Class c) {
        return Number.class.isAssignableFrom(c)
                || c == Byte.TYPE
                || c == Short.TYPE
                || c == Integer.TYPE
                || c == Long.TYPE
                || c == Float.TYPE
                || c == Double.TYPE;
    }

    public static boolean isNumberClass(Object obj) {
        return obj instanceof Number; // no need to check obj.getClass() == Byte.Type
    }

    public static boolean isBooleanClass(Class c) {
        return c == Boolean.TYPE || c == Boolean.class;
    }

    public static boolean isBooleanClass(Object obj) {
        return obj instanceof Boolean;
    }

    public static Object callMethod(Object obj, String name, Object[] params) {
        try {
            int paramCount = params != null ? params.length : 0;
            Method methodFound = null;
            Object[] realParams = null;
            Class<?> clazz = obj instanceof Class<?> ? (Class<?>) obj : obj.getClass();
            for (Method m : clazz.getMethods()) {
                if (!m.getName().equals(name)) {
                    continue;
                }
                if (m.isVarArgs()) {
                    // String.format("%d%d%d");
                    // String.format("%d%d%d", 1);
                    // String.format("%d%d%d", 1, 2, 3);
                    if (m.getParameterCount() - 1 > paramCount) { // NOTE illegal to call String.format().
                        continue;
                    }
                    Class[] classList = m.getParameterTypes();
                    boolean match = true;
                    int fixedLength = classList.length - 1;  // the last is varArg
                    if (classList[fixedLength] != Object[].class) { // NOTE only support Object[]
                        continue;
                    }
                    for (int i = 0; i < fixedLength; ++i) {
                        if (params[i] == null || classList[i].isInstance(params[i])) {
                            continue;
                        }
                        if (isNumberClass(params[i]) && isNumberClass(classList[i])) {
                            continue;
                        }
                        if (isBooleanClass(params[i]) && isBooleanClass(classList[i])) {
                            continue;
                        }
                        match = false;
                        break;
                    }
                    if (match) {
                        realParams = new Object[classList.length];
                        methodFound = m;
                        for (int i = 0; i < fixedLength; ++i) {
                            if (params[i] == null || classList[i].isInstance(params[i]) || isBooleanClass(params[i])) {
                                realParams[i] = params[i];
                            } else {
                                realParams[i] = castNumber(params[i], classList[i]);
                            }
                        }
                        Object[] varArgs = new Object[paramCount - fixedLength];
                        for (int i = 0; i < varArgs.length; ++i) {
                            varArgs[i] = params[i + fixedLength];
                        }
                        realParams[fixedLength] = varArgs;
                        break;
                    }

                } else {
                    if (m.getParameterCount() != paramCount) {
                        continue;
                    }
                    if (paramCount == 0) {
                        methodFound = m;
                        break;
                    }
                    Class[] classList = m.getParameterTypes();
                    boolean match = true;
                    for (int i = 0; i < classList.length; ++i) {
                        if (params[i] == null || classList[i].isInstance(params[i])) {
                            continue;
                        }
                        if (isNumberClass(params[i]) && isNumberClass(classList[i])) {
                            continue;
                        }
                        if (isBooleanClass(params[i]) && isBooleanClass(classList[i])) {
                            continue;
                        }
                        match = false;
                        break;
                    }
                    if (match) {
                        realParams = new Object[paramCount];
                        methodFound = m;
                        for (int i = 0; i < classList.length; ++i) {
                            if (params[i] == null || classList[i].isInstance(params[i]) || isBooleanClass(params[i])) {
                                realParams[i] = params[i];
                            } else {
                                realParams[i] = castNumber(params[i], classList[i]);
                            }
                        }
                        break;
                    }
                }
            }
            if (methodFound != null) {
                methodFound.setAccessible(true);
                return methodFound.invoke(obj, realParams);
            } else {
                return ObjUtils.NotFound;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace(); // TODO
            throw new RuntimeException("invalid to access method for: " + name, e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException("invalid to invoke method for: " + name, e);
        }
    }
}
