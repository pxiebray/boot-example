package com.ztest.boot.first.spring;

import com.ztest.boot.first.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/7/30 0030 00
 */
public class TestBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware, ApplicationListener {

    @Autowired
    private UserService userService;

    private ApplicationContext applicationContext;

    private int total;
    private int current;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        total = applicationContext.getBeanDefinitionCount();
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        current++;
        return bean;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationStartedEvent) {
            System.out.println("TestBeanPostProcessor done with beans " + current + " \n");
        }
    }
}
