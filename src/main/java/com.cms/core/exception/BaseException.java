package com.cms.core.exception;

/**
 * Created by taifuyu on 17/7/6.
 */
public class BaseException extends Exception {

    private String code;
    private String message;

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

}
