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
     * @return
     */
    public static ResponseResult genResult() {

        ResponseResult responseResult = ResponseResult.newInstance();
        responseResult.setSuccess(true);
        responseResult.setErrorInfo(ResultEnum.SUCCESS);

        return responseResult;
    }

    /**
     * 生成响应成功的(带正文)的结果
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> genResult(T data) {

        ResponseResult responseResult = ResponseResult.newInstance();
        responseResult.setSuccess(true);
        responseResult.setData(data);
        responseResult.setErrorInfo(ResultEnum.SUCCESS);

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
