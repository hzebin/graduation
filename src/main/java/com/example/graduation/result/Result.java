package com.example.graduation.result;

import lombok.Data;

import java.util.HashMap;

/**
 * <h3>graduation</h3>
 * <p>将data数据进行封装，以便返回给浏览器</p>
 *
 * @author : 黄泽彬
 * @date : 2020-02-20 12:20
 **/

@Data
public class Result {
    private Object data;
    private HashMap<String,Object> meta =new HashMap<>();

    public Result(Object data, String msg, Integer status) {
        meta.put("msg",msg);
        meta.put("status",status);
        this.data = data;
    }
}
