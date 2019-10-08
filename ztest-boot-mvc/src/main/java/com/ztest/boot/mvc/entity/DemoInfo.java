package com.ztest.boot.mvc.entity;

import java.io.Serializable;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/10/29 0029 18
 */
public class DemoInfo implements Serializable{
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DemoInfo{" + "age=" + age + ", name='" + name + '\'' + '}';
    }
}
