package com.ztest.boot.mvc.common.cache.config;

import com.ztest.boot.mvc.common.cache.CacheAdvisor;
import com.ztest.boot.mvc.common.cache.CacheInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * 自动装配自定义AOP
 *
 * @author
 * @version 1.0
 * @data 2018/7/13 0013 05
 */
@Configuration
public class CacheConfiguration implements ImportAware, ApplicationContextAware {
    private ApplicationContext applicationContext;
    private Map<String, Object> annotationAttributes;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 通过注解的import导入时，继承ImportAware获取注解中的参数
     * @param importMetadata
     */
    @Override
    public void setImportMetadata(AnnotationMetadata importMetadata) {
        annotationAttributes = importMetadata.getAnnotationAttributes(EnableCache.class.getName(), false);
        annotationAttributes.get("value");
    }

    @Bean
    public CacheAdvisor cacheAdvisor() {
        CacheAdvisor cacheAdvisor = new CacheAdvisor();
        cacheAdvisor.setAdvice(new CacheInterceptor());
        return cacheAdvisor;
    }
}
