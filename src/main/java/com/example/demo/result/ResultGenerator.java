package com.example.demo.result;

/**
 * 响应结果生成工具
 * @author Leon
 */
@SuppressWarnings({"rawtypes"})
public class ResultGenerator {

    /** 默认成功message */
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    /**
     * 成功结果
     * @param data 需要返回的数据 {@link T}
     * @param <T>泛型
     * @return result
     */
    public static <T> Result<T> genSuccessResult(T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        result.setData(data);
        return result;
    }
    
    public static <T> Result<T> genSuccessResult() {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        return result;
    }

    public static Result genFailResult(String message) {
        Result result = new Result();
        result.setCode(ResultCode.FAIL);
        result.setMessage(message);
        return result;
    }

    public static Result genNotFoundResult(String message) {
        Result result = new Result();
        result.setCode(ResultCode.NOT_FOUND);
        result.setMessage(message);
        return result;
    }

    public static Result genServerErrorResult(String message) {
        Result result = new Result();
        result.setCode(ResultCode.INTERNAL_SERVER_ERROR);
        result.setMessage(message);
        return result;
    }

    public static Result genCustomerResult(String code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
