package com.ztest.boot.mvc.common;

import java.lang.annotation.*;

/**
 * 基于interceptor实现的权限注解
 *
 * @author Administrator
 * @version 1.0
 * @data 2018/7/13 0013 20
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {
    String value() default "";
}
