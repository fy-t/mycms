package com.cms.core;

import com.cms.modules.entity.ResponseResult;
import com.cms.util.ResultEnum;
import com.cms.util.ResultGenerator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by taifuyu on 17/7/5.
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

//    @ExceptionHandler(RuntimeException.class)
//    @ResponseBody
//    public MyExceptionResponse exceptionHandler(RuntimeException e, HttpServletResponse response) {
//        MyExceptionResponse resp = new MyExceptionResponse();
//        resp.setCode(300);
//        resp.setMsg("exception-Handler"+e.getMessage());
//        return resp;
//    }


    /**
     * 系统异常处理，比如：404,500
     *
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseResult defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        log.error("", e);
        ResponseResult responseResult;
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            responseResult = ResultGenerator.genErrorResult(ResultEnum.BAD_REQUEST);
        } if(e instanceof  java.lang.IllegalStateException){
            responseResult = ResultGenerator.genErrorResult(ResultEnum.ILLEGAL_PARAMS);
        }else {
            responseResult = ResultGenerator.genErrorResult(ResultEnum.INTERNAL_SERVER_ERROR);
        }
        return responseResult;
    }


    @Data
    class MyExceptionResponse {
        int code;
        String msg;
    }


}
