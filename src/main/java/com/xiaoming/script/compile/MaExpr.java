package com.xiaoming.script.compile;

import com.xiaoming.script.utils.ObjUtils;
import com.xiaoming.script.utils.ObjectWrapper;
import com.xiaoming.script.utils.ObjectWrapperUtils;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author: xiaoming
 * @since: 2018-2-12
 */

public class MaExpr {
    public static class IdExpr implements Evaluable {
        String value;
        public IdExpr(String value) {
            this.value = value;
        }
        public Object eval(MaContext runtime) {
            return runtime.get(value);
        }
    }

    public static class FuncDefExpr implements Evaluable {
        String name = "";
        FunctionType function;
        @Override
        public Object eval(MaContext runtime) {
            FunctionType inst = function.makeInstance(runtime.getSub());
            if (name.length() > 0) {
                runtime.define(name, inst);
            }
            return inst;
        }
    }

    public static class MemberIndexExpr implements Evaluable { // v1[v2]
        Evaluable v1;
        Evaluable v2;
        boolean nullIndex = false;
        @Override
        public Object eval(MaContext runtime) {
            Object a = v1.eval(runtime);
            if (a == null && nullIndex) {
                return null;
            }
            Object b = v2.eval(runtime);
            ObjectWrapper objectWrapper = runtime.getObjectWrapper(a);
            if (objectWrapper != null) {
                Object r = ObjectWrapperUtils.getIndex(objectWrapper, b);
                if (r != ObjUtils.NotFound) {
                    return r;
                }
            }
            if (a.getClass().isArray()) {
                return Array.get(a, Converter.asInt(b));
            }
            return null;
        }
    }

    public static class MemberDotExpr implements Evaluable {
        Evaluable v1;
        String v2;
        boolean nullDot = false;
        int lineNumber = -1;
        @Override
        public Object eval(MaContext runtime) {
            Object a = v1.eval(runtime);
            if (a != null) {
                ObjectWrapper objectWrapper = runtime.getObjectWrapper(a);
                if (objectWrapper != null) {
                    Object r = ObjectWrapperUtils.getMember(objectWrapper, v2);
                    if (r != ObjUtils.NotFound) {
                        return r;
                    }
                }
                Object result = ObjUtils.getMember(a, v2);
                if (result != ObjUtils.NotFound) {
                    return result;
                }
            }
            Object result = FunctionType.evalUnderlying(runtime, a, v2, new Object[0]);
            if (result != ObjUtils.NotFound) {
                return result;
            }
            if (nullDot) {
                return null;
            } else {
                String message = "line " + lineNumber + ": error to call: " + v2;
                throw new RuntimeException(message);
            }
        }
    }

    public static class FuncCallExpr implements Evaluable {
        Evaluable v1;
        List<Evaluable> v2 = new ArrayList<>();
        @Override
        public Object eval(MaContext runtime) {
            Object r1 = v1.eval(runtime);
            if (r1 instanceof FunctionType) {
                FunctionType f = (FunctionType) r1;
                List<Object> paramList = new ArrayList<>();
                for (Evaluable evaluable : v2) {
                    Object param = evaluable.eval(runtime);
                    paramList.add(param);
                }
                if (runtime.isShadow) { // 预先定义的函数，面对平行作用域，需要使用平行作用域的上下文
                    return f.call(runtime, paramList);
                } else {
                    return f.call(paramList);
                }
            }
            return null;
        }
    }

    public static class MemberFuncCallExpr implements Evaluable {
        Evaluable v1;
        String name;
        List<Evaluable> v2 = new ArrayList<>();
        int lineNumber;
        boolean nullDot = false;

        @Override
        public Object eval(MaContext runtime) {
            Object r1 = v1.eval(runtime);
            Object[] params = new Object[v2.size()];
            for (int i = 0; i < params.length; ++i) {
                params[i] = v2.get(i).eval(runtime);
            }
            if (r1 != null) {
                ObjectWrapper objectWrapper = runtime.getObjectWrapper(r1);
                if (objectWrapper != null) {
                    Object r = ObjectWrapperUtils.callMethod(objectWrapper, name, params);
                    if (r != ObjUtils.NotFound) {
                        return r;
                    }
                }
                Object result = ObjUtils.callMethod(r1, name, params);
                if (result != ObjUtils.NotFound) {
                    return result;
                }
            }
            Object result = FunctionType.evalUnderlying(runtime, r1, name, params);
            if (result != ObjUtils.NotFound) {
                return result;
            }
            if (r1 == null && nullDot) {
                return null;
            } else {
                String message = "line " + lineNumber + ": error to call method: " + name;
                throw new RuntimeException(message);
            }
        }
    }

    public static class NotExpr implements Evaluable {
        boolean not = true;
        Evaluable v1;
        @Override
        public Object eval(MaContext runtime) {
            Object r1 = v1.eval(runtime);
            return Converter.asBool(r1) != not;
        }
    }

    public static class UnaryMinusExpr implements Evaluable {
        Evaluable v1;
        @Override
        public Object eval(MaContext runtime) {
            Object r1 = v1.eval(runtime);
            Object value = OpType.find("-").compute(0, r1);
            return value;
        }
    }

    public static class BiExpr implements Evaluable {
        OpType opType;
        Evaluable v1;
        Evaluable v2;
        BiExpr(String op, Evaluable v1, Evaluable v2) {
            this.opType = OpType.find(op);
            this.v1 = v1;
            this.v2 = v2;
        }
        @Override
        public Object eval(MaContext runtime) {
            Object r1 = v1.eval(runtime);
            Object r2 = v2.eval(runtime);
            Object r3 =  opType.compute(r1, r2);
            return r3;
        }
    }

    public static class AndExpr implements Evaluable {
        Evaluable v1;
        Evaluable v2;
        @Override
        public Object eval(MaContext runtime) {
            return Converter.asBool(v1.eval(runtime)) && Converter.asBool(v2.eval(runtime));
        }
    }

    public static class OrExpr implements Evaluable {
        Evaluable v1;
        Evaluable v2;
        @Override
        public Object eval(MaContext runtime) {
            return Converter.asBool(v1.eval(runtime)) || Converter.asBool(v2.eval(runtime));
        }
    }

    public static class TernaryExpr implements Evaluable {
        Evaluable v1;
        Evaluable v2;
        Evaluable v3;
        @Override
        public Object eval(MaContext runtime) {
            return Converter.asBool(v1.eval(runtime)) ? v2.eval(runtime) : v3.eval(runtime);
        }
    }

    public static class IdAssignExpr implements Evaluable {
        String name;
        OpType opType;
        Evaluable value;
        public IdAssignExpr(String name, String op, Evaluable value) {
            this.name = name;
            this.opType = OpType.find(op);
            this.value = value;
        }
        @Override
        public Object eval(MaContext runtime) {
            Object r3 = value.eval(runtime);
            if (opType == OpType.None) {
                runtime.set(name, r3);
                return r3;
            } else {
                Object r1 = runtime.get(name);
                Object value = runtime.set(name, opType.compute(r1, r3));
                return value;
            }
        }
    }

    public static class MemberIndexAssignExpr implements Evaluable {
        Evaluable v1;
        Evaluable v2;
        OpType opType;
        Evaluable v3;
        public MemberIndexAssignExpr(Evaluable v1, Evaluable v2, String op, Evaluable v3) {
            this.v1 = v1;
            this.v2 = v2;
            this.opType = OpType.find(op);
            this.v3 = v3;
        }
        @Override
        public Object eval(MaContext runtime) {
            Object a = v1.eval(runtime);
            Object b = v2.eval(runtime);
            Object c = v3.eval(runtime);
            if (a == null) {
                throw new RuntimeException("the result of expr 'todo' has not index method"); // TODO
            }
            ObjectWrapper objectWrapper = runtime.getObjectWrapper(a);
            if (objectWrapper != null) {
                Object r = ObjectWrapperUtils.setIndex(objectWrapper, b, c);
                if (r != ObjUtils.NotFound) {
                    return r;
                }
            }
            if (a.getClass().isArray()) {
                Array.set(a, (Integer) Converter.asInt(b), c);
                return c;
            }
            // TODO else ?
            return null;
        }
    }

    public static class MemberDotAssignExpr implements Evaluable {
        Evaluable v1;
        String v2;
        OpType opType;
        Evaluable v3;
        int lineNumber = -1;
        public MemberDotAssignExpr(Evaluable v1, String v2, String op, Evaluable v3) {
            this.v1 = v1;
            this.v2 = v2;
            this.opType = OpType.find(op);
            this.v3 = v3;
        }
        @Override
        public Object eval(MaContext runtime) { // a.b = c
            Object a = v1.eval(runtime);
            Object c = v3.eval(runtime);
            ObjectWrapper objectWrapper = runtime.getObjectWrapper(a);
            if (objectWrapper != null) {
                Object r = ObjectWrapperUtils.setMember(objectWrapper, v2, c); // consider append assign like "+="
                if (r != ObjUtils.NotFound) {
                    return r;
                }
            }
            if (opType == OpType.None) {
                ObjUtils.setMember(a, v2, c);
                return c;
            } else {
                Object b = ObjUtils.getMember(a, v2);
                if (b == ObjUtils.NotFound) {
                    String message = "line " + lineNumber + ": error to call: " + v2;
                    throw new RuntimeException(message);
                }
                c = opType.compute(b, c);
                ObjUtils.setMember(a, v2, c);
                return c;
            }
        }
    }

    public static class Exprs implements Evaluable {
        List<Evaluable> list = new ArrayList<>();
        @Override
        public Object eval(MaContext runtime) {
            Object r = null;
            for (Evaluable evaluable : list) {
                r = evaluable.eval(runtime);
            }
            return r;
        }
    }

    public static class ArrayExpr implements Evaluable {
        List<Evaluable> list = new ArrayList<>();
        @Override
        public Object eval(MaContext runtime) {
            List<Object> valueList = new ArrayList<>();
            for (Evaluable evaluable : list) {
                valueList.add(evaluable.eval(runtime));
            }
            return valueList;
        }
    }

    public static class ObjectExpr implements Evaluable { // TODO update to MapExpr
        HashMap<String, Evaluable> map = new HashMap<>();
        @Override
        public Object eval(MaContext runtime) {
            Map<String, Object> valueMap = new HashMap<>();
            for (Map.Entry<String, Evaluable> entry : map.entrySet()) {
                Object value = entry.getValue().eval(runtime);
                valueMap.put(entry.getKey(), value);
            }
            return valueMap;
        }
    }

    public static class StringFormatExpr implements Evaluable {
        List<Evaluable> evaluableList = new ArrayList<>();
        @Override
        public Object eval(MaContext runtime) {
            StringBuilder sb = new StringBuilder();
            for (Evaluable evaluable : evaluableList) {
                Object result = evaluable.eval(runtime);
                if (result != null) {
                    sb.append(String.valueOf(result));
                }
            }
            return sb.toString();
        }
    }

    public static class BackStringFormatSquareExpr implements Evaluable {
        String rawText;
        String text;
        String functionName;

        public BackStringFormatSquareExpr(String str, String functionName) {
            this.rawText = str;
            this.text = str.substring(1, str.length() - 1);
            this.functionName = functionName;
        }

        @Override
        public Object eval(MaContext runtime) {
            Object obj = runtime.get(functionName);
            if (obj != null && obj instanceof FunctionType) {
                FunctionType f = (FunctionType) obj;
                return f.call(runtime, new ArrayList<Object>(){{add(text);}});
            }
            return rawText;
        }
    }


    public static class BlockStat implements Evaluable {
        List<Evaluable> list = new ArrayList<>();
        @Override
        public Object eval(MaContext runtime) {
            MaContext sub = runtime.getSub();
            Object r = null;
            for (Evaluable evaluable : list) {
                r = evaluable.eval(sub);
                if (sub.flowState != MaContext.FlowOrder) {
                    runtime.flowState = sub.flowState;
                    return r;
                }
            }
            return r;
        }
    }

    public static class VarStat implements Evaluable {
        List<Map.Entry<String, Evaluable>> list = new ArrayList<>();
        @Override
        public Object eval(MaContext runtime) {
            Object r = null;
            for (Map.Entry<String, Evaluable> entry : list) {
                r = entry.getValue().eval(runtime);
                runtime.define(entry.getKey(), r);
            }
            return r;
        }
    }

    public static class EmptyStat implements Evaluable {
        @Override
        public Object eval(MaContext runtime) {
            return null;
        }
    }

    public static class ExprsStat implements Evaluable {
        List<Evaluable> list = new ArrayList<>();
        @Override
        public Object eval(MaContext runtime) {
            Object r = null;
            runtime.flowState = MaContext.FlowOrder;
            for (Evaluable evaluable : list) {
                r = evaluable.eval(runtime);
                if (runtime.flowState != MaContext.FlowOrder) {
                    return r;
                }
            }
            return r;
        }
    }

    public static class IfStat implements Evaluable {
        Evaluable v1;
        Evaluable v2;
        Evaluable v3;
        @Override
        public Object eval(MaContext runtime) {
            MaContext sub = runtime.getSub();
            Object result;
            if (Converter.asBool(v1.eval(sub))) {
                runtime.flowState = sub.flowState;
                result = v2.eval(sub);
            } else {
                result = v3.eval(sub);
            }
            runtime.flowState = sub.flowState;
            return result;
        }
    }

    public static class ForItStat implements Evaluable { // for(var name = v1; v2; v3) { v4;}
        String name;
        Evaluable v1;
        Evaluable v2;
        Evaluable v3;
        Evaluable v4;
        @Override
        public Object eval(MaContext runtime) {
            MaContext sub1 = runtime.getSub();
            sub1.define(name, v1.eval(sub1));
            Object r = null;
            while (true) {
                Object v2Result = v2.eval(sub1);
                boolean condition = Converter.asBool(v2Result);
                if (!condition) {
                    break;
                }
                MaContext sub2 = sub1.getSub();
                r = v4.eval(sub2);
                if (sub2.flowState == MaContext.FlowReturn || sub2.flowState == MaContext.FlowException) {
                    runtime.flowState = sub2.flowState;
                    return r;
                }
                if (sub2.flowState == MaContext.FlowBreak) {
                    return r;
                }
                v3.eval(sub1);
            }
            return r;
        }
    }

    public static class ForInStat implements Evaluable { // for( v1 in v2) { v3; } TODO consider array
        String v1;
        Evaluable v2;
        Evaluable v3;
        @Override
        public Object eval(MaContext runtime) {
            MaContext sub1 = runtime.getSub();
            Object r = null;
            Object r2 = v2.eval(sub1);
            if (r2 instanceof Iterable){
                for (Object item : (Iterable)r2){
                    MaContext sub2 = sub1.getSub();
                    sub2.define(v1, item);
                    r = v3.eval(sub2);
                    if (sub2.flowState == MaContext.FlowReturn || sub2.flowState == MaContext.FlowException) {
                        runtime.flowState = sub2.flowState;
                        return r;
                    }
                    if (sub2.flowState == MaContext.FlowBreak) {
                        return r;
                    }
                }
            } else if (r2.getClass().isArray()) {
                int length = Array.getLength(r2);
                for (int i = 0; i < length; ++i) {
                    MaContext sub2 = sub1.getSub();
                    Object item = Array.get(r2, i);
                    sub2.define(v1, item);
                    r = v3.eval(sub2);
                    if (sub2.flowState == MaContext.FlowReturn || sub2.flowState == MaContext.FlowException) {
                        runtime.flowState = sub2.flowState;
                        return r;
                    }
                    if (sub2.flowState == sub2.FlowBreak) {
                        return r;
                    }
                }
            } else {
                MaContext sub2 = sub1.getSub();
                sub2.define(v1, r2);
                r = v3.eval(sub2);
                if (sub2.flowState == MaContext.FlowBreak) {
                    return r;
                }
                return r;
            }
            return r;
        }
    }

    public static class ReturnStat implements Evaluable {
        Evaluable v1;
        @Override
        public Object eval(MaContext runtime) {
            Object r = v1.eval(runtime);
            runtime.flowState = MaContext.FlowReturn;
            return r;
        }
    }

    public static class BreakStat implements Evaluable {
        Evaluable v1;
        @Override
        public Object eval(MaContext runtime) {
            Object r = v1.eval(runtime);
            runtime.flowState = MaContext.FlowBreak;
            return r;
        }
    }

    public static class ContinueStat implements Evaluable {
        static ContinueStat inst = new ContinueStat();
        @Override
        public Object eval(MaContext runtime) {
            runtime.flowState = MaContext.FlowContinue;
            return null;
        }
    }

    public static class StatsStat implements Evaluable {
        List<Evaluable> list = new ArrayList<>();
        @Override
        public Object eval(MaContext runtime) {
            Object r = null;
            runtime.flowState = MaContext.FlowOrder;
            for (Evaluable evaluable : list) {
                r = evaluable.eval(runtime);
                if (runtime.flowState != MaContext.FlowOrder) {
                    return r;
                }
            }
            return r;
        }
    }

    public static class Program implements Evaluable {
        List<Evaluable> list = new ArrayList<>();
        @Override
        public Object eval(MaContext runtime) {
            Object r = null;
            for (Evaluable evaluable : list) {
                r = evaluable.eval(runtime);
                if (runtime.flowState == MaContext.FlowReturn || runtime.flowState == MaContext.FlowException) {
                    return r;
                }
            }
            return r;
        }
    }
}
