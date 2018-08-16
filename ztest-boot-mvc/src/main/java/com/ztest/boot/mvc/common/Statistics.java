package com.ztest.boot.mvc.common;

import java.lang.annotation.*;

/**
 * 基于@Aspect配置AOP实现的统计注解
 *
 * @author Administrator
 * @version 1.0
 * @data 2018/7/13 0013 43
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Statistics {
    String value();
}
