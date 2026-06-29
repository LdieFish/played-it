package com.playedit.common.auth;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.playedit.common.config.JwtConfig;
import com.playedit.common.exception.BusinessException;
import com.playedit.common.exception.ErrorCode;
import com.playedit.common.response.ApiResponse;
import com.playedit.common.response.ResultUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * JWT 登录校验过滤器
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 10)
public class JwtAuthFilter extends OncePerRequestFilter {

    private static final List<String> WHITE_LIST = List.of(
            "/user/login/wx",
            "/doc.html",
            "/webjars/",
            "/v3/api-docs/",
            "/swagger-ui/",
            "/swagger-ui.html",
            "/favicon.ico",
            "/error"
    );

    @Resource
    private JwtConfig jwtConfig;

    @Resource
    private JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if (HttpMethod.OPTIONS.matches(request.getMethod())) {
            filterChain.doFilter(request, response);
            return;
        }
        String servletPath = request.getServletPath();
        if (isWhiteListed(servletPath)) {
            filterChain.doFilter(request, response);
            return;
        }
        try {
            String token = extractToken(request);
            if (StrUtil.isBlank(token)) {
                writeError(response, ErrorCode.NOT_LOGIN_ERROR.getCode(), ErrorCode.NOT_LOGIN_ERROR.getMessage());
                return;
            }
            LoginUser loginUser = jwtUtils.parseToken(token);
            LoginUserHolder.set(loginUser);
            filterChain.doFilter(request, response);
        } catch (BusinessException e) {
            writeError(response, e.getCode(), e.getMessage());
        } finally {
            LoginUserHolder.clear();
        }
    }

    private boolean isWhiteListed(String servletPath) {
        if (WHITE_LIST.contains(servletPath)) {
            return true;
        }
        return WHITE_LIST.stream().anyMatch(path -> path.endsWith("/") && servletPath.startsWith(path));
    }

    private String extractToken(HttpServletRequest request) {
        String headerValue = request.getHeader(jwtConfig.getHeader());
        if (StrUtil.isBlank(headerValue)) {
            return null;
        }
        String prefix = jwtConfig.getPrefix();
        if (StrUtil.isNotBlank(prefix) && headerValue.startsWith(prefix)) {
            return headerValue.substring(prefix.length()).trim();
        }
        return headerValue.trim();
    }

    private void writeError(HttpServletResponse response, int code, String message) throws IOException {
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        ApiResponse<?> body = ResultUtils.error(code, message);
        response.getWriter().write(JSONUtil.toJsonStr(body));
    }
}
