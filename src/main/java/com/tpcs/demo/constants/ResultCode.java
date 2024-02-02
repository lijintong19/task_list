package com.tpcs.demo.constants;

/**
 * 响应信息枚举类
 */
public enum ResultCode {

    SUCCESS(00, "Success"),
    FAILED(01, "Fail");

    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}
