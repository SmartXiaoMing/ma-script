package com.xiaoming.script.compile;

/**
 * @author: xiaoming
 * @since: 2019-08-26
 */
public class Converter {
    static Converter TNull = new Converter(0);
    static Converter TBool = new Converter(1, Boolean.class, Boolean.TYPE) {
        public boolean toBool(Object obj) {
            Boolean v = (Boolean) obj;
            return v;
        }

        public byte toByte(Object obj) {
            Boolean v = (Boolean) obj;
            return (byte) (v ? 0 : 1);
        }

        public short toShort(Object obj) {
            Boolean v = (Boolean) obj;
            return (short) (v ? 0 : 1);
        }

        public int toInt(Object obj) {
            Boolean v = (Boolean) obj;
            return v ? 0 : 1;
        }

        public long toLong(Object obj) {
            Boolean v = (Boolean) obj;
            return v ? 0L : 1L;
        }

        public float toFloat(Object obj) {
            Boolean v = (Boolean) obj;
            return (float) (v ? 0.0 : 1.0);
        }

        public double toDouble(Object obj) {
            Boolean v = (Boolean) obj;
            return v ? 0.0 : 1.0;
        }
    };
    static Converter TByte = new Converter(2, Byte.class, Byte.TYPE) {
        public boolean toBool(Object obj) {
            Byte v = (Byte) obj;
            return v != 0;
        }

        public byte toByte(Object obj) {
            Byte v = (Byte) obj;
            return v;
        }

        public short toShort(Object obj) {
            Byte v = (Byte) obj;
            return v.shortValue();
        }

        public int toInt(Object obj) {
            Byte v = (Byte) obj;
            return v.intValue();
        }

        public long toLong(Object obj) {
            Byte v = (Byte) obj;
            return v.longValue();
        }

        public float toFloat(Object obj) {
            Byte v = (Byte) obj;
            return v.floatValue();
        }

        public double toDouble(Object obj) {
            Byte v = (Byte) obj;
            return v.doubleValue();
        }
    };
    static Converter TShort = new Converter(3, Short.class, Short.TYPE) {
        public boolean toBool(Object obj) {
            Short v = (Short) obj;
            return v != 0;
        }

        public byte toByte(Object obj) {
            Short v = (Short) obj;
            return v.byteValue();
        }

        public short toShort(Object obj) {
            Short v = (Short) obj;
            return v;
        }

        public int toInt(Object obj) {
            Short v = (Short) obj;
            return v.intValue();
        }

        public long toLong(Object obj) {
            Short v = (Short) obj;
            return v.longValue();
        }

        public float toFloat(Object obj) {
            Short v = (Short) obj;
            return v.floatValue();
        }

        public double toDouble(Object obj) {
            Short v = (Short) obj;
            return v.doubleValue();
        }
    };
    static Converter TInteger = new Converter(4, Integer.class, Integer.TYPE) {
        public boolean toBool(Object obj) {
            Integer v = (Integer) obj;
            return v != 0;
        }

        public byte toByte(Object obj) {
            Integer v = (Integer) obj;
            return v.byteValue();
        }

        public short toShort(Object obj) {
            Integer v = (Integer) obj;
            return v.shortValue();
        }

        public int toInt(Object obj) {
            Integer v = (Integer) obj;
            return v;
        }

        public long toLong(Object obj) {
            Integer v = (Integer) obj;
            return v.longValue();
        }

        public float toFloat(Object obj) {
            Integer v = (Integer) obj;
            return v.floatValue();
        }

        public double toDouble(Object obj) {
            Integer v = (Integer) obj;
            return v.doubleValue();
        }
    };
    static Converter TLong = new Converter(5, Long.class, Long.TYPE) {
        public boolean toBool(Object obj) {
            Long v = (Long) obj;
            return v != 0;
        }

        public byte toByte(Object obj) {
            Long v = (Long) obj;
            return v.byteValue();
        }

        public short toShort(Object obj) {
            Long v = (Long) obj;
            return v.shortValue();
        }

        public int toInt(Object obj) {
            Long v = (Long) obj;
            return v.intValue();
        }

        public long toLong(Object obj) {
            Long v = (Long) obj;
            return v;
        }

        public float toFloat(Object obj) {
            Long v = (Long) obj;
            return v.floatValue();
        }

        public double toDouble(Object obj) {
            Long v = (Long) obj;
            return v.doubleValue();
        }
    };
    static Converter TFloat = new Converter(6, Float.class, Float.TYPE) {
        public boolean toBool(Object obj) {
            Float v = (Float) obj;
            return v != 0;
        }

        public byte toByte(Object obj) {
            Float v = (Float) obj;
            return v.byteValue();
        }

        public short toShort(Object obj) {
            Float v = (Float) obj;
            return v.shortValue();
        }

        public int toInt(Object obj) {
            Float v = (Float) obj;
            return v.intValue();
        }

        public long toLong(Object obj) {
            Float v = (Float) obj;
            return v.longValue();
        }

        public float toFloat(Object obj) {
            Float v = (Float) obj;
            return v;
        }

        public double toDouble(Object obj) {
            Float v = (Float) obj;
            return v.doubleValue();
        }
    };
    static Converter TDouble = new Converter(7, Double.class, Double.TYPE) {
        public boolean toBool(Object obj) {
            Double v = (Double) obj;
            return v != 0;
        }

        public byte toByte(Object obj) {
            Double v = (Double) obj;
            return v.byteValue();
        }

        public short toShort(Object obj) {
            Double v = (Double) obj;
            return v.shortValue();
        }

        public int toInt(Object obj) {
            Double v = (Double) obj;
            return v.intValue();
        }

        public long toLong(Object obj) {
            Double v = (Double) obj;
            return v.longValue();
        }

        public float toFloat(Object obj) {
            Double v = (Double) obj;
            return v.floatValue();
        }

        public double toDouble(Object obj) {
            Double v = (Double) obj;
            return v;
        }
    };
    static Converter[] array = new Converter[] {
        TBool, TByte, TShort, TInteger, TLong, TFloat, TDouble
    };

    Converter(int level, Class... clazz) {
        this.level = level;
        this.clazz = clazz;
    }
    private Class[] clazz;
    public final int level;

    public boolean toBool(Object obj) {
        return false;
    }

    public byte toByte(Object obj) {
        return 0;
    }

    public short toShort(Object obj) {
        return 0;
    }

    public int toInt(Object obj) {
        return 0;
    }

    public long toLong(Object obj) {
        return 0L;
    }

    public float toFloat(Object obj) {
        return (float) 0.0;
    }

    public double toDouble(Object obj) {
        return 0.0;
    }

    public static Converter findByObj(Object object) {
        if (object == null) {
            return TNull;
        }
        for (Converter converter : array) {
            for (Class c : converter.clazz) {
                if (c.isInstance(object)) {
                    return converter;
                }
            }
        }
        return new Converter(10, object.getClass());
    }

    public static boolean asBool(Object obj) {
        return findByObj(obj).toBool(obj);
    }

    public static byte asByte(Object obj) {
        return findByObj(obj).toByte(obj);
    }

    public static short asShort(Object obj) {
        return findByObj(obj).toShort(obj);
    }

    public static int asInt(Object obj) {
        return findByObj(obj).toInt(obj);
    }

    public static long asLong(Object obj) {
        return findByObj(obj).toLong(obj);
    }

    public static float asFloat(Object obj) {
        return findByObj(obj).toFloat(obj);
    }

    public static double asDouble(Object obj) {
        return findByObj(obj).toDouble(obj);
    }
}
