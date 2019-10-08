package com.ztest.boot.mvc.websocket;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/11/9 0009 21
 */
public class BulletMessageVO {
    String username;
    String message;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BulletMessageVO{" + "username='" + username + '\'' + ", message='" + message + '\'' + '}';
    }
}
