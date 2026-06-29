package com.playedit.common.auth;

/**
 * 当前登录用户上下文（ThreadLocal）
 */
public final class LoginUserHolder {

    private static final ThreadLocal<LoginUser> LOGIN_USER = new ThreadLocal<>();

    private LoginUserHolder() {
    }

    public static void set(LoginUser loginUser) {
        LOGIN_USER.set(loginUser);
    }

    public static LoginUser get() {
        return LOGIN_USER.get();
    }

    public static Long getUserId() {
        LoginUser loginUser = LOGIN_USER.get();
        return loginUser == null ? null : loginUser.getUserId();
    }

    public static void clear() {
        LOGIN_USER.remove();
    }
}
