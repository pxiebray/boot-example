package com.ztest.boot.mvc.common;

import java.lang.annotation.*;

/**
 * 基于自定义Advice实现的AOP动态缓存注解
 *
 * @author Administrator
 * @version 1.0
 * @data 2018/7/13 0013 00
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cached {
    String value();
}
