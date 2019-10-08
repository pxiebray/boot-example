package com.ztest.boot.first;

import com.ztest.boot.first.spring.TestBeanFactoryPostProcessor;
import com.ztest.boot.first.spring.TestBeanPostProcessor;
import com.ztest.boot.first.spring.TestImportBeanDefinitionRegistrar;
import com.ztest.boot.first.spring.TestRegistryPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * SpringBoot 四大神器
 * 1, autoconfig
 * 2, starters
 * 3, actuator
 * 4, cli
 *
 * @author pxie
 * @version 1.0
 * @data 2018/7/5 0005 26
 */
@SpringBootApplication
public class FirstApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(FirstApplication.class, args);
    }


    @Configuration
    @Import(TestImportBeanDefinitionRegistrar.class)
    static class SpringConfigurationTests {
        @Bean
        public TestBeanFactoryPostProcessor beanFactoryPostProcessor() {
            return new TestBeanFactoryPostProcessor();
        }

        @Bean
        public TestBeanPostProcessor beanPostProcessor() {
            return new TestBeanPostProcessor();
        }

        @Bean
        public TestRegistryPostProcessor beanDefinitionRegistryPostProcessor() {
            return new TestRegistryPostProcessor();
        }
    }
}
