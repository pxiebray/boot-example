package com.ztest.spring.beans;

import com.ztest.spring.service.UserService;
import com.ztest.spring.xml.Register;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/7/31 0031 33
 */
public class IocContainer {

    public static void main(String[] args) {
        Resource resource = new ClassPathResource("spring.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.getUser("spring name");

        Register register = beanFactory.getBean("register", Register.class);
        System.out.println(register.toString());
    }
}
