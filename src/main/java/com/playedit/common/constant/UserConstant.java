package com.playedit.common.constant;

/**
 * 用户常量
 */
public interface UserConstant {

    /**
     * 服务端登录态存储 key（Session / Redis 等）
     * <p>
     * 当前项目使用 JWT 无状态登录，请求身份由 Token 校验，此常量暂未使用。
     * 若后续增加 Redis 会话、强制下线、多端踢人等功能，可用作统一 key，例如：
     * {@code redis.set(USER_LOGIN_STATE + ":" + userId, token)}
     */
    String USER_LOGIN_STATE = "user_login";

    /**
     * 默认角色
     */
    String DEFAULT_ROLE = "user";

    /**
     * 管理员角色
     */
    String ADMIN_ROLE = "admin";
}
