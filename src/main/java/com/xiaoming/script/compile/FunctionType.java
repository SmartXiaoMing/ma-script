package com.xiaoming.script.compile;

import com.xiaoming.script.utils.ObjUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiaoming
 * @since: 2019-08-27
 */
public class FunctionType {
    public MaContext context;
    public String name = "";
    public List<String> nameList = new ArrayList<>();
    public Evaluable body = Evaluable.Null;

    public Object call(List<Object> valueList) {
        return call(context, valueList);
    }

    public Object call(MaContext context, List<Object> valueList) {
        MaContext subContext = context.getSub();
        for (int i = 0; i < nameList.size(); ++i) {
            String name = nameList.get(i);
            Object value = null;
            if (i < valueList.size()) {
                value = valueList.get(i);
            }
            subContext.define(name, value);
        }
        Object r = body.eval(subContext);
        if (subContext.flowState != MaContext.FlowException) {
            subContext.flowState = MaContext.FlowOrder;
        }
        return r;
    }

    public FunctionType makeInstance(MaContext context) {
        FunctionType that = new FunctionType();
        that.context = context;
        that.name = name;
        that.nameList = nameList;
        that.body = body;
        return that;
    }

    public static String getUnderlyingName(String methodName) {
        return "__" + methodName;
    }

    public static Object evalUnderlying(MaContext runtime, Object self, String methodName, Object[] params) {
        String underlyingName = FunctionType.getUnderlyingName(methodName);
        Object method = runtime.get(underlyingName);
        if (method != null && method instanceof FunctionType) {
            List<Object> paramList = new ArrayList<>(params.length + 1);
            paramList.add(self);
            for (int i = 0; i < params.length; ++i) {
                paramList.add(params[i]);
            }
            return ((FunctionType) method).call(paramList);
        } else {
            return ObjUtils.NotFound;
        }
    }
}
