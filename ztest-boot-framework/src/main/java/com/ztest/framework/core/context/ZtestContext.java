package com.ztest.framework.core.context;

/**
 * @author 基于ThreadLocal的上下文数据
 * @version 1.0
 * @data 2019/4/3 0003 21
 */
public class ZtestContext {
    private static ThreadLocal<Object> ztestContext = new ThreadLocal<>();

    public static Object getRequestHeader() {
        Object obj = ztestContext.get();
        if (null == obj) {
            obj = new Object();
        }
        return obj;
    }

    public static void setRequestHeader(Object obj) {
        ztestContext.set(obj);
    }

    public static void reset(){
        ztestContext.remove();
    }

}
