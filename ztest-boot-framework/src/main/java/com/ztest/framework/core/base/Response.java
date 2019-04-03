package com.ztest.framework.core.base;

import java.util.Objects;

/**
 * @author Administrator
 * @version 1.0
 * @data 2019/4/3 0003 16
 */
public class Response<T> {

    private Boolean status;
    private String code;
    private String msg;
    private T data;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response<?> response = (Response<?>) o;
        return Objects.equals(status, response.status) && Objects.equals(code, response.code) && Objects.equals(msg, response.msg) && Objects.equals(data, response.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, code, msg, data);
    }
}
