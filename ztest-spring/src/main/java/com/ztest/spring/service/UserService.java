package com.ztest.spring.service;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/7/31 0031 32
 */
public class UserService {

    private String name;

    private DemoService demoService;

    /**
     * construct method
     */
    public UserService() {
        System.out.println("construct userService");
    }

    /**
     * init method
     */
    public void init() {
        System.out.println("init userService");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getUser(String name) {
        System.out.println("hello " + name);
    }

    public String getName() {
        return name;
    }

    public DemoService getDemoService() {
        return demoService;
    }

    public void setDemoService(DemoService demoService) {
        this.demoService = demoService;
    }

    @Override
    public String toString() {
        return "UserService{" + "name='" + name + '\'' + '}';
    }
}
