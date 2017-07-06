package com.cms.modules.entity;

import com.cms.util.ResultEnum;
import lombok.Data;

/**
 * Created by taifuyu on 17/7/6.
 */
@Data
public class ResponseResult<T> {

    private boolean success;

    private String message;

    private T data;

    /* 不提供直接设置errorCode的接口，只能通过setErrorInfo方法设置错误信息 */
    private String errorCode;

    private ResponseResult() {
    }

    public static <T> ResponseResult<T> newInstance() {
        return new ResponseResult<T>();
    }


    // 设置错误信息
    public void setErrorInfo(ResultEnum responseErrorEnum) {
        this.errorCode = responseErrorEnum.getCode();
        this.message = responseErrorEnum.getMessage();
    }
}
