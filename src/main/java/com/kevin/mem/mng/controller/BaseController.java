package com.kevin.mem.mng.controller;

import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.exception.BaseException;
import com.kevin.mem.mng.enums.ErrorCodeEnum;
import com.kevin.mem.mng.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

/**
 * @Description baseController封装统一的异常处理
 * @Author 丁海峰
 */
@Slf4j
public class BaseController {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    BaseResponse<Object> handleControllerException(HttpServletRequest request, Throwable ex) {
        BaseResponse<Object> baseResponse = new BaseResponse<>();
        String errorCode = null;
        String message = null;
        if (ex instanceof BaseException) {
            BaseException bex = (BaseException) ex;
            //错误码
            errorCode = bex.getErrorCode();
            //错误信息
            message = bex.getMessage();

            log.error("{} request errorCode：{}，errorMsg：{}，errorResponse：{}", request.getRequestURI(), errorCode, message, JsonUtil.toJSONString(baseResponse));
        } else if (ex instanceof BindException) {
            errorCode = ErrorCodeEnum.REQUEST_PARAM_ERROR.getCode();
            BindingResult result = ((BindException) ex).getBindingResult();
            StringBuilder stringBuilder = new StringBuilder();
            Optional.ofNullable(result.getFieldErrors()).orElse(new ArrayList<>())
                    .stream().forEach(f -> {
                stringBuilder.append(f.getField())
                        .append(" ")
                        .append(f.getDefaultMessage())
                        .append(", 当前值: '")
                        .append(f.getRejectedValue())
                        .append("'; ");
            });

            message = stringBuilder.toString();

            log.error("{} request errorCode：{}，errorMsg：{}，errorResponse：{}", request.getRequestURI(), errorCode, message, JsonUtil.toJSONString(baseResponse));
        } else if (ex instanceof MethodArgumentNotValidException) {
            //BindException and MethodArgumentNotValidException implements BindingResult
            errorCode = ErrorCodeEnum.REQUEST_PARAM_ERROR.getCode();
            BindingResult result = ((MethodArgumentNotValidException) ex).getBindingResult();
            StringBuilder stringBuilder = new StringBuilder();
            Optional.ofNullable(result.getFieldErrors()).orElse(new ArrayList<>())
                    .stream().forEach(f -> {
                stringBuilder.append(f.getField())
                        .append(" ")
                        .append(f.getDefaultMessage())
                        .append(", 当前值: '")
                        .append(f.getRejectedValue())
                        .append("'; ");
            });

            message = stringBuilder.toString();
            log.error("{} request errorCode：{}，errorMsg：{}，errorResponse：{}", request.getRequestURI(), errorCode, message, JsonUtil.toJSONString(baseResponse));
        } else if (ex instanceof ConstraintViolationException) {
            errorCode = ErrorCodeEnum.REQUEST_PARAM_ERROR.getCode();
            ConstraintViolationException cex = (ConstraintViolationException) ex;

            StringBuilder stringBuilder = new StringBuilder();
            Optional.ofNullable(cex.getConstraintViolations()).orElse(new HashSet<>()).stream()
                    .forEach(v -> {
                        String invald = v.getInvalidValue() != null ? v.getInvalidValue().toString() : "null";
                        stringBuilder
                                .append(v.getPropertyPath())
                                .append(" ")
                                .append(v.getMessage())
                                .append(", 当前值: '")
                                .append(invald.length() < 50 ? invald : invald.substring(0, 47) + "...")
                                .append("'; ");
                    });
            message = stringBuilder.toString();

            log.error("{} request errorCode：{}，errorMsg：{}，errorResponse：{}", request.getRequestURI(), errorCode, message, JsonUtil.toJSONString(baseResponse));
        } else {
            errorCode = ErrorCodeEnum.SYSTEM_ERROR.getCode();
            message = "系统错误";
            log.error("{} request errorCode：{}，errorMsg：{}，errorResponse：{}", request.getRequestURI(), errorCode, message + ex.getMessage(), JsonUtil.toJSONString(baseResponse), ex);
        }

        baseResponse.setErrorCode(errorCode);
        baseResponse.setErrorMessage(message);
        baseResponse.setSuccess(false);
        return baseResponse;
    }
}
	