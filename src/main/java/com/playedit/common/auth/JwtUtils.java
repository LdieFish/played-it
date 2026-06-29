package com.playedit.common.auth;

import cn.hutool.core.convert.Convert;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.signers.JWTSigner;
import cn.hutool.jwt.signers.JWTSignerUtil;
import com.playedit.common.config.JwtConfig;
import com.playedit.common.exception.BusinessException;
import com.playedit.common.exception.ErrorCode;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT 工具类
 */
@Component
public class JwtUtils {

    private static final String CLAIM_USER_ID = "userId";
    private static final String CLAIM_USER_ROLE = "userRole";
    private static final String CLAIM_EXP = "exp";

    @Resource
    private JwtConfig jwtConfig;

    /**
     * 生成 Token
     */
    public String createToken(Long userId, String userRole) {
        Map<String, Object> payload = new HashMap<>();
        payload.put(CLAIM_USER_ID, userId);
        payload.put(CLAIM_USER_ROLE, userRole);
        payload.put(CLAIM_EXP, Instant.now().plus(jwtConfig.getExpireDays(), ChronoUnit.DAYS).toEpochMilli());
        return JWTUtil.createToken(payload, signer());
    }

    /**
     * 解析并校验 Token
     */
    public LoginUser parseToken(String token) {
        try {
            JWT jwt = JWTUtil.parseToken(token);
            if (!jwt.verify(signer())) {
                throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR, "Token 无效");
            }
            Long exp = Convert.toLong(jwt.getPayload(CLAIM_EXP));
            if (exp != null && exp < System.currentTimeMillis()) {
                throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR, "Token 已过期");
            }
            Long userId = Convert.toLong(jwt.getPayload(CLAIM_USER_ID));
            String userRole = Convert.toStr(jwt.getPayload(CLAIM_USER_ROLE));
            if (userId == null) {
                throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR, "Token 无效");
            }
            return new LoginUser(userId, userRole);
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR, "Token 无效");
        }
    }

    private JWTSigner signer() {
        return JWTSignerUtil.hs256(jwtConfig.getSecret().getBytes(StandardCharsets.UTF_8));
    }
}
