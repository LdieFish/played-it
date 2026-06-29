package com.playedit.common.auth;

import com.playedit.common.annotation.AuthCheck;
import com.playedit.common.constant.UserConstant;
import com.playedit.common.exception.BusinessException;
import com.playedit.common.exception.ErrorCode;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 权限校验切面，配合 {@link AuthCheck} 使用
 */
@Aspect
@Component
public class AuthCheckAspect {

    @Around("@annotation(authCheck)")
    public Object doInterceptor(ProceedingJoinPoint joinPoint, AuthCheck authCheck) throws Throwable {
        LoginUser loginUser = LoginUserHolder.get();
        if (loginUser == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
        }
        String mustRole = authCheck.mustRole();
        if (mustRole.isEmpty()) {
            return joinPoint.proceed();
        }
        if (UserConstant.ADMIN_ROLE.equals(mustRole)
                && !UserConstant.ADMIN_ROLE.equals(loginUser.getUserRole())) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        return joinPoint.proceed();
    }
}
