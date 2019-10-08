package com.ztest.boot.mvc;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.ztest.boot.mvc.common.cache.config.EnableCache;
import com.ztest.boot.mvc.common.interceptor.AuthInterceptor;
import com.ztest.boot.mvc.common.interceptor.PermissionInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author xiepeng
 * @version 1.0
 * @data 2018/7/5 0005 47  extends SpringBootServletInitializer
 */
@SpringBootApplication
@EnableCache("cache")
public class MvcApplication  implements ApplicationContextAware{

    ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static void main(String[] args) {
        SpringApplication.run(MvcApplication.class, args);
    }

    /**
     * 配置mvc拦截器
     *
     * @see WebMvcConfigurer
     */
    @Configuration
    public class MvcAutoConfig {
        @Bean
        public AuthInterceptor authInterceptor() {
            return new AuthInterceptor();
        }

        @Bean
        public PermissionInterceptor permissionInterceptor() {
            return new PermissionInterceptor();
        }

        @Bean
        public HttpMessageConverter httpMessageConverter() {
            FastJsonHttpMessageConverter messageConverter = new FastJsonHttpMessageConverter();
            FastJsonConfig fastJsonConfig = new FastJsonConfig();
            fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullStringAsEmpty);
            messageConverter.setFastJsonConfig(fastJsonConfig);
            return messageConverter;
        }


//        @Override
//        public void addInterceptors(InterceptorRegistry registry) {
//            InterceptorRegistration auth = registry.addInterceptor(authInterceptor());
//            auth.addPathPatterns("**/pv/**");
//
//            InterceptorRegistration permission = registry.addInterceptor(permissionInterceptor());
//            permission.addPathPatterns("/**");
//        }
//
//        @Override
//        public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//            FastJsonHttpMessageConverter messageConverter = new FastJsonHttpMessageConverter();
//            FastJsonConfig fastJsonConfig = new FastJsonConfig();
////            fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullStringAsEmpty);
//            messageConverter.setFastJsonConfig(fastJsonConfig);
//
//            converters.add(0, messageConverter);
//        }
    }
}
