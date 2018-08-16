package com.ztest.boot.mvc.common.cache;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/7/13 0013 54
 */
public class CacheAdvisor extends AbstractBeanFactoryPointcutAdvisor {
    @Override
    public Pointcut getPointcut() {
        return new CachePointcut();
    }
}
