package com.atguigu.springcloud.controller;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map runtimeException(RuntimeException e) {
        Map map = new HashMap<String,String>();
        map.put("a","1");
        map.put("error","运行时异常!!");
        return map;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public Map illegalArgumentException(IllegalArgumentException e) {
        Map map = new HashMap<String,String>();
        map.put("aaa","1333");
        map.put("erro111r","illegalArgumentException!!");
        return map;
    }
}
