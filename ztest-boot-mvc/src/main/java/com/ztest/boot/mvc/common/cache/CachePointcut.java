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
    public boolean matches(Method method, Class<?> targetClass) {
        if (!matches(method.getDeclaringClass())) {
            return false;
        }

        Cached methodCached = method.getAnnotation(Cached.class);
        Cached classCached = targetClass.getAnnotation(Cached.class);
        return methodCached != null;
    }

    @Override
    public boolean matches(Class<?> aClass) {
        String className = aClass.getName();
        if (className.startsWith("com.ztest.boot.mvc.service")) {
            return true;
        } else {
            return false;
        }
    }
}
