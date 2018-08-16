package com.ztest.spring.xml;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;


/**
 * @author Administrator
 * @version 1.0
 * @data 2018/7/31 0031 16
 */
public class RegisterBeanDefinitionParser implements BeanDefinitionParser {

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(Register.class);
        beanDefinition.setLazyInit(false);
        beanDefinition.setInitMethodName("init");
        beanDefinition.getPropertyValues().add("host", element.getAttribute("host"));
        beanDefinition.getPropertyValues().add("port", element.getAttribute("port"));

        BeanDefinitionRegistry registry = parserContext.getRegistry();
        registry.registerBeanDefinition(Register.class.getName(), beanDefinition);
        return beanDefinition;
    }
}
