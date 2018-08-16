package com.ztest.boot.mvc.common.cache.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 使用Import导入外部Configuration
 *
 * @author Administrator
 * @version 1.0
 * @data 2018/7/13 0013 36
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(CacheConfiguration.class)
public @interface EnableCache {
    String value();
}
