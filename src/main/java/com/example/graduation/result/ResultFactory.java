package com.example.graduation.result;

/**
 * <h3>graduation</h3>
 * <p>RestFactory工厂，将data数据进行封装</p>
 *
 * @author : 黄泽彬
 * @date : 2020-02-20 12:21
 **/

public class ResultFactory {
    public static Result buildSuccessResult(Object data,String message) {
        return buildResult(data,message,StatusCode.SUCCESS.code);
    }

    public static Result buildFailResult(String message) {
        return buildResult(null,message,StatusCode.FAIL.code);
    }

    public static Result buildResult(Object data, String message,Integer resultCode) {
        return new Result(data, message, resultCode);
    }
}
