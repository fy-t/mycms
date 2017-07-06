package com.cms.modules.entity;

import com.cms.util.ResultEnum;

/**
 * Created by taifuyu on 17/7/6.
 */
public class ResponseResult<T> {

    private boolean success;

    private String message;

    private T data;

    /* 不提供直接设置code的接口，只能通过setErrorInfo方法设置错误信息 */
    private String code;

    private ResponseResult() {
    }

    public static <T> ResponseResult<T> newInstance() {
        return new ResponseResult<T>();
    }


    // 设置错误信息
    public void setErrorInfo(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

}
