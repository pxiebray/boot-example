package com.ztest.spring;

import com.ztest.spring.service.DemoService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Administrator
 * @version 1.0
 * @data 2019/4/10 0010 51
 */
public class SpringMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

//        beanFactory();
    }

    public static void beanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        GenericBeanDefinition testBdf = new GenericBeanDefinition();
        testBdf.setBeanClass(DemoService.class);
        testBdf.setLazyInit(false);

        beanFactory.registerBeanDefinition("demoService", testBdf);
        DemoService demoService = (DemoService) beanFactory.getBean("demoService");
        System.out.println(demoService.getDemo());
    }
}
