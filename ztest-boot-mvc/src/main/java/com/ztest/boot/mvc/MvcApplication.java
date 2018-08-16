package com.ztest.boot.mvc;

import com.ztest.boot.mvc.common.cache.config.EnableCache;
import com.ztest.boot.mvc.common.interceptor.AuthInterceptor;
import com.ztest.boot.mvc.common.interceptor.PermissionInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xiepeng
 * @version 1.0
 * @data 2018/7/5 0005 47
 */
@SpringBootApplication
@EnableCache("cache")
public class MvcApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MvcApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MvcApplication.class, args);
    }

    /**
     * 配置mvc拦截器
     */
    @Configuration
    public class MvcAutoConfig implements WebMvcConfigurer {
        @Bean
        public AuthInterceptor authInterceptor() {
            return new AuthInterceptor();
        }

        @Bean
        public PermissionInterceptor permissionInterceptor() {
            return new PermissionInterceptor();
        }

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            InterceptorRegistration auth = registry.addInterceptor(authInterceptor());
            auth.addPathPatterns("**/pv/**");

            InterceptorRegistration permission = registry.addInterceptor(permissionInterceptor());
            permission.addPathPatterns("/**");
        }
    }
}
