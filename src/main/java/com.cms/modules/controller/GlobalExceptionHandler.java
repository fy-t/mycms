package com.cms.modules.controller;

import com.cms.modules.entity.ResponseResult;
import com.cms.util.ResultEnum;
import com.cms.util.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by taifuyu on 17/7/5.
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
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
//        log.error("", e);
        return getResPonseResult(e);
    }


    /**
     * 获取结果
     *
     * @param e
     * @return
     */
    private ResponseResult getResPonseResult(Exception e) {
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            return ResultGenerator.genErrorResult(ResultEnum.BAD_REQUEST);
        }

        if (e instanceof java.lang.IllegalStateException) {
            return ResultGenerator.genErrorResult(ResultEnum.ILLEGAL_PARAMS);
        }

        if (e instanceof org.springframework.web.method.annotation.MethodArgumentTypeMismatchException) {
            return ResultGenerator.genErrorResult(ResultEnum.METHOD_ARGUMENT_TYPE_MISMATCH);
        }

        return ResultGenerator.genErrorResult(ResultEnum.INTERNAL_SERVER_ERROR);
    }


}
