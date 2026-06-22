package com.playedit.common.response;

import com.playedit.common.exception.ErrorCode;
import lombok.Data;

import java.io.Serializable;

/**
 * 统一 API 响应格式：{ code, message, data }
 *
 * @param <T> 响应数据类型
 */
@Data
public class ApiResponse<T> implements Serializable {

    private int code;

    private T data;

    private String message;

    public ApiResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public ApiResponse(int code, T data) {
        this(code, data, "");
    }

    public ApiResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), null, errorCode.getMessage());
    }
}
