package com.playedit.module.core.dto;

import lombok.Data;

/**
 * 微信登录请求
 */
@Data
public class WxLoginRequest {

    /**
     * wx.login() 获取的 code
     */
    private String code;

    /**
     * 昵称（可选，首次登录时由前端传入）
     */
    private String nickname;

    /**
     * 头像 URL（可选）
     */
    private String avatarUrl;
}
