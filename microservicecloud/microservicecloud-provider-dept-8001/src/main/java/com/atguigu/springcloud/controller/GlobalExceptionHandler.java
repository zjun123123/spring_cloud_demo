package com.atguigu.springcloud.controller;


import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map runtimeException(RuntimeException e) {
        Map map = new HashMap<String,String>();
        map.put("a","runtimeException");
        map.put("RuntimeException",e.getMessage());
        return map;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public Map illegalArgumentException(IllegalArgumentException e) {
        Map map = new HashMap<String,String>();
        map.put("aaa","illegalArgumentException");
        map.put("erro111r","illegalArgumentException!!");
        return map;
    }


    @ExceptionHandler(BindException.class)
    @ResponseBody
    public String handleControllerException(HttpServletRequest request, Throwable ex) {
        List<ObjectError> errors = null;
        if (ex instanceof BindException) {
            BindException bindException = BindException.class.cast(ex);
            errors = bindException.getBindingResult().getAllErrors();

            //   baseResponse.setCode(400);
            //     baseResponse.setMsg("参数错误：" + errors.get(0).getDefaultMessage());
        }
        return errors.get(0).getDefaultMessage() + "------------------------";
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public String methodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException ex) {
        List<ObjectError> errors = null;
      //  BindingResult bindingResult = /ex.getBindingResult();
      //  if (ex instanceof BindException) {
            BindException bindException = BindException.class.cast(ex);
            errors = bindException.getBindingResult().getAllErrors();
     //   }
        return errors.get(0).getDefaultMessage() + "------------------------";
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map exception(Exception e) {
        Map map = new HashMap<String,String>();
        map.put("aaa","Exception");
        map.put("erro111r",e.getMessage());
        return map;

//        logger.error( ":" + CommonUtil.getHttpClientInfo(request), ex);
//        MethodArgumentNotValidException c = (MethodArgumentNotValidException) ex;
//        List<ObjectError> errors =c.getBindingResult().getAllErrors();
//        StringBuffer errorMsg=new StringBuffer();
//        errors.stream().forEach(x -> errorMsg.append(x.getDefaultMessage()).append(";"));
//        pouplateExceptionResponse(response, HttpStatus.INTERNAL_SERVER_ERROR, errorMsg.toString());

    }

//    private void pouplateExceptionResponse(HttpServletResponse response, HttpStatus errorCode, String errorMessage) {
//        try {
//            response.sendError(errorCode.value(), errorMessage);
//        } catch (IOException e) {
//        }


}
