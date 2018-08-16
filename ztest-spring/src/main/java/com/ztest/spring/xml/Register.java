package com.ztest.spring.xml;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/7/31 0031 12
 */
public class Register {

    private String host;
    private int port;

    public void init() {
        System.out.println("init register");
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "Register{" + "host='" + host + '\'' + ", port=" + port + '}';
    }
}
