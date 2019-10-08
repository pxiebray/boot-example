package com.ztest.spring.beans.process;

import com.ztest.spring.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/10/30 0030 01
 */
public class TestBeanFactoryPostProcess implements BeanFactoryPostProcessor,EnvironmentAware,ApplicationContextAware,ResourceLoaderAware {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(applicationContext);
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println(environment);
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println(resourceLoader);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("beanFactoryPostProcess");
    }
}
