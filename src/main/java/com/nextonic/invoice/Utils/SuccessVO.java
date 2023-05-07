package com.nextonic.invoice.Utils;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class SuccessVO implements Serializable {
    private static final long serialVersionUID = 5545860428411369724L;
    public static final int RETCODE_SUCCESS = 0;
    public static final int RETCODE_FAIL_DB = 100;

    @JsonInclude(Include.NON_DEFAULT)
    private int code = 222;

    @JsonInclude(Include.NON_NULL)
    private String message = null;

    @JsonInclude(Include.NON_NULL)
    private Object data;

    @JsonInclude(Include.NON_ABSENT)
    private Integer totalRecords;

    @JsonInclude(Include.NON_ABSENT)
    private Integer pageNo;

    public SuccessVO() {
    }

    public SuccessVO(String message) {
        this.message = message;
    }

    public SuccessVO(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public SuccessVO(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public SuccessVO(int code, String message, Object data, Integer totalRecords, Integer pageNo) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.totalRecords = totalRecords;
        this.pageNo = pageNo;
    }

    public SuccessVO(int code, String message, Object data, Integer totalRecords) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.totalRecords = totalRecords;
    }

    public SuccessVO(int code, String message) {
        this.code = code;
        this.message = message;
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

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

}
