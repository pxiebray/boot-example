package com.ztest.boot.first.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.PlaceholderConfigurerSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.PropertyPlaceholderHelper;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/7/30 0030 02
 */
@Service
public class UserService implements ApplicationContextAware, ResourceLoaderAware, EnvironmentAware {
    private ApplicationContext applicationContext;
    private Environment environment;
    private ResourceLoader resourceLoader;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @PostConstruct
    public void test() {
        PropertyPlaceholderHelper helper = new PropertyPlaceholderHelper(PlaceholderConfigurerSupport.DEFAULT_PLACEHOLDER_PREFIX,
                PlaceholderConfigurerSupport.DEFAULT_PLACEHOLDER_SUFFIX, PlaceholderConfigurerSupport.DEFAULT_VALUE_SEPARATOR, true);
        Properties properties = new Properties();
        properties.setProperty("server.port", "1");
        String port = helper.replacePlaceholders("${server.port}", properties);
        System.out.println("test " + port);
    }
}
