package com.cms.core;

import com.cms.modules.entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志统一打印
 * <p>
 * Created by taifuyu on 17/7/4.
 */
@Aspect
@Component
@Slf4j
public class LogService {

    private ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    @Pointcut("execution(public * com.cms.modules.controller..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        ResponseResult responseResult = (ResponseResult) ret;

        log.info("{},^{},^{},^{},^{},^{},^{}ms"
                , request.getRequestURI()
                , request.getRemoteAddr()
                , request.getMethod()
                , responseResult.getCode()
                , responseResult.getMessage()
                , request.getQueryString()
                , (System.currentTimeMillis() - startTime.get()));
    }

}
