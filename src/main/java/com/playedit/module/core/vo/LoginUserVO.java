package com.playedit.module.core.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * 登录用户信息
 */
@Data
public class LoginUserVO {

    @Schema(description = "用户 id")
    private Long id;

    @Schema(description = "用户昵称")
    private String nickname;

    @Schema(description = "用户头像")
    private String avatarUrl;

    @Schema(description = "用户名")
    private String steamId;

    @Schema(description = "用户名")
    private String steamNickname;

    @Schema(description = "用户名")
    private String steamBindType;

    @Schema(description = "用户名")
    private Integer steamVerified;

    @Schema(description = "用户角色：user-普通用户 admin-管理员")
    private String userRole;

    @Schema(description = "用户名")
    private Date steamBindTime;

    /**
     * 登录 Token（仅登录接口返回）
     */
    private String token;
}
