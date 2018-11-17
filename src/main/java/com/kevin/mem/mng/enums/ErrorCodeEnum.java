package com.kevin.mem.mng.enums;

import lombok.Getter;

@Getter
public enum ErrorCodeEnum {
    SUCCESS("000000", "success"),
    FALL_BACK("100002", "fallback"),
    SYSTEM_ERROR("RMS100000", "系统错误"),
    REQUEST_PARAM_ERROR("RMS100002", "参数错误"),
    ;

    private String code;
    private String message;

    ErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
