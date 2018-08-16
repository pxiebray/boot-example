package com.ztest.boot.mvc.common.cache;

import com.ztest.boot.mvc.common.Cached;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/7/13 0013 54
 */
public class CachePointcut extends StaticMethodMatcherPointcut implements ClassFilter {

    @Override
    public boolean matches(Method method, Class<?> aClass) {
        Cached cached = method.getAnnotation(Cached.class);
        return cached != null;
    }

    @Override
    public boolean matches(Class<?> aClass) {
        String className = aClass.getName();
        return className.startsWith("com.ztest.boot");
    }
}
