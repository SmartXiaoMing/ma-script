package com.xiaoming.script.utils;

/**
 * @author: xiaoming
 * @since: 2019-11-14
 *
 * usage
 *
 * class IntArray {
 *     int[] value = new int[100];
 *     public int size = 0;
 *     public int get(int i) {
 *         return value[i];
 *     }
 *     public void set(int i, int v) {
 *         value[i] = v;
 *     }
 *     public int maxLength() {
 *         return value.length;
 *     }
 *     public int length() {
 *         return size;
 *     }
 * }
 *
 * class IntArrayWrapper implements IntArray {
 *     Person person;
 *     public void _wrap(Person p) { //
 *         this.person = p;
 *     }
 *     public int _getIndex(int i) { // we can call `intArray[0]`
 *         return p.get(i);
 *     }
 *     public void _setIndex(int i, int v) { // we call `intArray[0] = 1`
 *         p.set(i, v);
 *     }
 *     public Object _getMember(String name) {  // we can call `intArray.cap`
 *          if (name.equals(“cap”) {
 *              return size;
 *          }
 *          return null;
 *     }
 *     public Object _setMember(String name, Object value) {  // we can call `intArray.cap = 0`
 *          if (name.equals(“cap”) {
 *              size = value;
 *          }
 *          return value;
 *     }
 *     public void maxSize() { // we can call `intArray.maxSize`
 *         return value.length;
 *     }
 *     public void maxLength() { // this will shadow the origin IntArray.maxLength()
 *         return value.length + 1;
 *     }
 *     // anyway we can call `intArray.length()` without defined in this wrapper class
 * }
 *
 */
public abstract class ObjectWrapperUtils {
    public static final String GetIndex = "_getIndex"; // implements the method means array get, eg. a[0]
    public static final String SetIndex = "_setIndex"; // implements the method means array set, eg. a[0] = 1
    public static final String GetMember = "_getMember"; // implements the method means array get, eg. student.age
    public static final String SetMember = "_setMember"; // implements the method means array set, eg. student.age = 10
    public static Object getIndex(ObjectWrapper wrapper, Object index) {
        try {
            return ObjUtils.callMethod(wrapper, ObjectWrapperUtils.GetIndex, new Object[]{index});
        } catch (Exception e) {
            return ObjUtils.NotFound;
        }
    }

    public static Object setIndex(ObjectWrapper wrapper, Object index, Object value) {
        try {
            return ObjUtils.callMethod(wrapper, ObjectWrapperUtils.SetIndex, new Object[]{index, value});
        } catch (Exception e) {
            return ObjUtils.NotFound;
        }
    }

    public static Object getMember(ObjectWrapper wrapper, String index) {
        try {
            return ObjUtils.callMethod(wrapper, ObjectWrapperUtils.GetMember, new Object[]{index});
        } catch (Exception e) {
            return ObjUtils.NotFound;
        }
    }

    public static Object setMember(ObjectWrapper wrapper, String index, Object value) {
        try {
            return ObjUtils.callMethod(wrapper, ObjectWrapperUtils.SetMember, new Object[]{index, value});
        } catch (Exception e) {
            return ObjUtils.NotFound;
        }
    }

    public static Object callMethod(ObjectWrapper wrapper, String method, Object[] params) {
        try {
            return ObjUtils.callMethod(wrapper, method, params);
        } catch (Exception e) {
            return ObjUtils.NotFound;
        }
    }
}
