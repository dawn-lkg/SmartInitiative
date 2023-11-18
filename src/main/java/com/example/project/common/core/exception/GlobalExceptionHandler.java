package com.example.project.common.core.exception;

import com.example.project.common.core.Constants;
import com.example.project.common.core.utils.CommonUtil;
import com.example.project.common.core.web.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @author chenliming
 * @date 2023/8/6 15:25
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @ResponseBody
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result methodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e,
                                                     HttpServletResponse response){
        CommonUtil.addCrossHeaders(response);
        return new Result(Constants.RESULT_ERROR_CODE,"请求方式不正确");
    }
    @ResponseBody
    @ExceptionHandler(AccessDeniedException.class)
    public Result<?> accessDeniedExceptionHandler(AccessDeniedException e, HttpServletResponse response) {
        CommonUtil.addCrossHeaders(response);
        return new Result<>(Constants.UNAUTHORIZED_CODE, Constants.UNAUTHORIZED_MSG).setError(e.toString());
    }
    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public Result<?> businessExceptionHandler(BusinessException e, HttpServletResponse response) {
        CommonUtil.addCrossHeaders(response);
        return new Result<>(e.getCode(), e.getMessage());
    }
    @ResponseBody
    @ExceptionHandler(Throwable.class)
    public Result<?> exceptionHandler(Throwable e, HttpServletResponse response) {
        logger.error(e.getMessage(), e);
        CommonUtil.addCrossHeaders(response);
        return new Result<>(Constants.RESULT_ERROR_CODE, Constants.RESULT_ERROR_MSG).setError(e.toString());
    }

}
