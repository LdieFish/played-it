package com.playedit.common.response;

import com.playedit.common.exception.ErrorCode;

/**
 * 快速构造 API 响应的工具类
 */
public class ResultUtils {

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, data, "ok");
    }

    public static ApiResponse<?> error(ErrorCode errorCode) {
        return new ApiResponse<>(errorCode);
    }

    public static ApiResponse<?> error(int code, String message) {
        return new ApiResponse<>(code, null, message);
    }

    public static ApiResponse<?> error(ErrorCode errorCode, String message) {
        return new ApiResponse<>(errorCode.getCode(), null, message);
    }
}
