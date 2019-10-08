package com.ztest.spring.beans;

import com.ztest.spring.beans.process.TestBeanPostProcess;
import com.ztest.spring.service.UserService;
import com.ztest.spring.xml.Register;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/7/31 0031 33
 */
public class IocContainer {

    public static void beanFactoryContainer() {
        Resource resource = new ClassPathResource("spring.xml");
        ConfigurableBeanFactory beanFactory = new XmlBeanFactory(resource);
        beanFactory.addBeanPostProcessor(new TestBeanPostProcess());

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.getUser("spring name");

        Register register = beanFactory.getBean(Register.class);
        System.out.println(register.toString());

    }

    public static void applicationContextContainer() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.getUser("spring name");

        Environment environment = applicationContext.getEnvironment();
        System.out.println(environment.getProperty("os.name"));
    }

    public static void main(String[] args) {
        //beanFactoryContainer();

        applicationContextContainer();
    }
}
