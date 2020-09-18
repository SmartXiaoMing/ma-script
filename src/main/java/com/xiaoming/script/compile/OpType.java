package com.xiaoming.script.compile;

import com.xiaoming.script.utils.ObjUtils;

/**
 * @author: xiaoming
 * @since: 2019-08-21
 */
public enum OpType {
    None() {  // +
        @Override
        public Object compute(Object... p) {
            return p != null && p.length > 0 ? p[0] : null;
        }
    },
    Add("+", "+=", "++") {  // +
        @Override
        public Object compute(Object... p) {
            if (p[0] == null) {
                return p[1];
            }
            if (p[1] == null) {
                return p[0];
            }
            Converter c0 = Converter.findByObj(p[0]);
            Converter c1 = Converter.findByObj(p[1]);
            if (c0.level <= Converter.TInteger.level && c1.level <= Converter.TInteger.level) {
                return c0.toInt(p[0]) + c1.toInt(p[1]);
            }
            if (c0.level <= Converter.TLong.level && c1.level <= Converter.TLong.level) {
                return c0.toLong(p[0]) + c1.toLong(p[1]);
            }
            if (c0.level <= Converter.TDouble.level && c1.level <= Converter.TDouble.level) {
                return c0.toDouble(p[0]) + c1.toDouble(p[1]);
            }
            return String.valueOf(p[0]) + String.valueOf(p[1]);
        }
    },
    Minus("-", "-=", "--") { // -
        @Override
        public Object compute(Object... p) {
            Converter c0 = Converter.findByObj(p[0]);
            Converter c1 = Converter.findByObj(p[1]);
            if (c0.level <= Converter.TInteger.level && c1.level <= Converter.TInteger.level) {
                return c0.toInt(p[0]) - c1.toInt(p[1]);
            }
            if (c0.level <= Converter.TLong.level && c1.level <= Converter.TLong.level) {
                return c0.toLong(p[0]) - c1.toLong(p[1]);
            }
            return c0.toDouble(p[0]) - c1.toDouble(p[1]);
        }
    },
    Mult("*", "*=") {  // *
        @Override
        public Object compute(Object... p) {
            Converter c0 = Converter.findByObj(p[0]);
            Converter c1 = Converter.findByObj(p[1]);
            if (c0.level <= Converter.TInteger.level && c1.level <= Converter.TInteger.level) {
                return c0.toInt(p[0]) * c1.toInt(p[1]);
            }
            if (c0.level <= Converter.TLong.level && c1.level <= Converter.TLong.level) {
                return c0.toLong(p[0]) * c1.toLong(p[1]);
            }
            return c0.toDouble(p[0]) * c1.toDouble(p[1]);
        }
    },
    Divide("/", "/=") {  // /
        @Override
        public Object compute(Object... p) {
            Converter c0 = Converter.findByObj(p[0]);
            Converter c1 = Converter.findByObj(p[1]);
            if (c0.level <= Converter.TInteger.level && c1.level <= Converter.TInteger.level) {
                Integer b = c1.toInt(p[1]);
                return b == 0 ? null : c0.toInt(p[0]) / b;
            }
            if (c0.level <= Converter.TLong.level && c1.level <= Converter.TLong.level) {
                Long b = c1.toLong(p[1]);
                return b == 0 ? null : c0.toLong(p[0]) / b;
            }
            Double b = c1.toDouble(p[1]);
            return b == 0.0 ? null : c0.toDouble(p[0]) / b;
        }
    },
    Mod("%", "%=") { // %
        @Override
        public Object compute(Object... p) {
            Converter c0 = Converter.findByObj(p[0]);
            Converter c1 = Converter.findByObj(p[1]);
            if (c0.level <= Converter.TInteger.level && c1.level <= Converter.TInteger.level) {
                Integer b = c1.toInt(p[1]);
                return b == 0 ? null : c0.toInt(p[0]) % b;
            }
            Long b = c1.toLong(p[1]);
            return b == 0 ? null : c0.toLong(p[0]) % b;
        }
    },
    Lt("<") {
        @Override
        public Object compute(Object... p) {
            return ObjUtils.compare(p[0], p[1]) < 0;
        }
    },
    Le("<=") {
        @Override
        public Object compute(Object... p) {
            return ObjUtils.compare(p[0], p[1]) <= 0;
        }
    },
    Gt(">") {
        @Override
        public Object compute(Object... p) {
            return ObjUtils.compare(p[0], p[1]) > 0;
        }
    },
    Ge(">=") {
        @Override
        public Object compute(Object... p) {
            return ObjUtils.compare(p[0], p[1]) >= 0;
        }
    },
    Ne("!=") {
        @Override
        public Object compute(Object... p) {
            return ObjUtils.compare(p[0], p[1]) != 0;
        }
    },
    Eq2("==") {
        @Override
        public Object compute(Object... p) {
            return ObjUtils.compare(p[0], p[1]) == 0;
        }
    },
    Like("~=") {
        @Override
        public Object compute(Object... p) {
            return ObjUtils.like(p[0], p[1]);
        }
    },
    ;

    String[] symbolArray;
    OpType(String ...symbolArray) {
        this.symbolArray = symbolArray;
    }
    public abstract Object compute(Object... p);
    public static OpType find(String symbol) {
        for (OpType opType : OpType.values()) {
            for (String s : opType.symbolArray) {
                if (s.equals(symbol)) {
                    return opType;
                }
            }
        }
        return None;
    }
}
