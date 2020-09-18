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
public interface ObjectWrapper {
    void _wrap(Object obj);
}
