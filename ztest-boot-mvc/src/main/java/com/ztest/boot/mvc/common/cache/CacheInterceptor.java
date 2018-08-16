package com.ztest.boot.mvc.common.cache;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Advice接口，methodInterceptor为around类型
 * @see org.aopalliance.aop.Advice
 *
 * @author Administrator
 * @version 1.0
 * @data 2018/7/13 0013 54
 */
public class CacheInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object result =  methodInvocation.proceed();
        return result;
    }
}
