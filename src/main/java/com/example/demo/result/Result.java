package com.example.demo.result;

/**
 * 返回结果对象
 * @author Leon
 */
public class Result <T>{
    /**
     * 响应状态码
     */
    private String code;
    /**
     * 响应mesage
     */
    private String message;
    /**
     * 返回数据泛型类
     */
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCode(ResultCode resultCode) {
        this.code = String.valueOf(resultCode.code());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
