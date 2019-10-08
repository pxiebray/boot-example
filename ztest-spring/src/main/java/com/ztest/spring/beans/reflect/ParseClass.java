package com.ztest.spring.beans.reflect;

import com.ztest.spring.service.UserService;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/10/29 0029 00
 */
public class ParseClass {
    // 类型信息
    public void parseType(Class<?> classz) {
        System.out.println("typeName: " + classz.getTypeName());
        System.out.println("simpleName: " + classz.getSimpleName());
        System.out.println("name: " + classz.getName());

    }

    // 构造器
    public void parseConstruct(Class<?> classz) {
        Constructor<?>[] constructors = classz.getConstructors();
        System.out.println("调用getConstructors方法,返回class对象及其父类的所有public类型constructs");
        Arrays.stream(constructors).forEach(constructor -> System.out.println(constructor.getName()));

        Constructor<?>[] declaredConstructors = classz.getDeclaredConstructors();
        System.out.println("调用getDeclaredConstructors方法,仅返回当前类声明的所有constructs");
        Arrays.stream(declaredConstructors).forEach(constructor -> System.out.println(constructor.getName()));
    }

    // 方法
    public void parseMethod(Class<?> classz) {
        Method[] methods = classz.getMethods();
        System.out.println("调用getMethods方法,返回当前类及其父类的所有public方法");
        Arrays.stream(methods).forEach(method -> System.out.println(method.getName()));

        Method[] declaredMethods = classz.getDeclaredMethods();
        System.out.println("调用getDeclaredMethods方法，仅返回当前类声明的所有方法");
        Arrays.stream(declaredMethods).forEach(method -> System.out.println(method.getName()));
    }

    // 属性
    public void parseField(Class<?> classz) {
        Field[] fields = classz.getFields();
        System.out.println("调用getFields方法,返回class对象及其父类的所有public类型field");
        Arrays.stream(fields).forEach(field -> System.out.println(field.getName()));

        Field[] declaredFields = classz.getDeclaredFields();
        System.out.println("调用getDeclaredFields方法,仅返回当前类声明的所有field");
        Arrays.stream(declaredFields).forEach(field -> System.out.println(field.getName()));
    }


    public void constructObject(Class<?> classz) {
        try {
            Object t = classz.newInstance();
            Method method = classz.getMethod("getUser", String.class);
            method.invoke(t, "hello word");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Class classz = UserService.class;

        ParseClass parseClass = new ParseClass();
        parseClass.parseType(classz);
        parseClass.parseConstruct(classz);
        parseClass.parseMethod(classz);
        parseClass.parseField(classz);

        parseClass.constructObject(classz);
    }
}
