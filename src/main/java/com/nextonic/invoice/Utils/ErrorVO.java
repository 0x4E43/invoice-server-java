package com.nextonic.invoice.Utils;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ErrorVO implements Serializable {
    private static final long serialVersionUID = 5545860428411369724L;

    public static final int RETCODE_SUCCESS = 0;
    public static final int RETCODE_FAIL_DB = 100;

    @JsonInclude(Include.NON_DEFAULT)
    private int code = 333;

    @JsonInclude(Include.NON_NULL)
    private String message = null;

    @JsonInclude(Include.NON_NULL)
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ErrorVO(String message) {
        this.message = message;
    }

    public ErrorVO(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorVO() {
    }

}
