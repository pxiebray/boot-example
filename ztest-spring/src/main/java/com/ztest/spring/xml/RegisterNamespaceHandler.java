package com.ztest.spring.xml;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/7/31 0031 16
 */
public class RegisterNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("register", new RegisterBeanDefinitionParser());
    }
}
