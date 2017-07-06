package com.cms.util;

import com.cms.modules.entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springside.modules.utils.mapper.JsonMapper;

/**
 * Created by taifuyu on 17/7/6.
 */
@Slf4j
public class ResultGenerator {

    private static JsonMapper jsonMapper = new JsonMapper();

    /**
     * 生成响应成功的(不带正文)的结果
     *
     * @param message 成功提示信息
     * @return ResponseResult
     */
    public static ResponseResult genResult(String message) {

        ResponseResult responseResult = ResponseResult.newInstance();
        responseResult.setSuccess(true);
        responseResult.setErrorCode(ResultEnum.SUCCESS.getCode());
        responseResult.setMessage(message);

        return responseResult;
    }

    /**
     * 生成响应成功(带正文)的结果
     *
     * @param data    结果正文
     * @param message 成功提示信息
     * @return ResponseResult<T>
     */
    public static <T> ResponseResult<T> genResult(T data, String message) {

        ResponseResult<T> responseResult = ResponseResult.newInstance();
        responseResult.setSuccess(true);
        responseResult.setData(data);
        responseResult.setErrorCode(ResultEnum.SUCCESS.getCode());
        responseResult.setMessage(message);

        if (log.isDebugEnabled()) {
            log.debug("--------> result:{}", jsonMapper.toJson(responseResult));
        }

        return responseResult;
    }

    /**
     * 生成响应失败的结果
     *
     * @param message 自定义错误信息
     * @return ResponseResult
     */
    public static ResponseResult genErrorResult(String message) {

        ResponseResult responseResult = ResponseResult.newInstance();
        responseResult.setSuccess(false);
        responseResult.setMessage(message);

        if (log.isDebugEnabled()) {
            log.debug("--------> result:{}", jsonMapper.toJson(responseResult));
        }

        return responseResult;
    }

    /**
     * 生成响应失败(带errorCode)的结果
     *
     * @param responseErrorEnum 失败信息
     * @return ResponseResult
     */
    public static ResponseResult genErrorResult(ResultEnum responseErrorEnum) {

        ResponseResult responseResult = ResponseResult.newInstance();
        responseResult.setSuccess(false);
        responseResult.setErrorInfo(responseErrorEnum);

        if (log.isDebugEnabled()) {
            log.debug("--------> result:{}", jsonMapper.toJson(responseResult));
        }

        return responseResult;
    }

}
