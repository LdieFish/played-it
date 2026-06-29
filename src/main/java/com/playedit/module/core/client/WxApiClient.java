package com.playedit.module.core.client;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.playedit.common.exception.BusinessException;
import com.playedit.common.exception.ErrorCode;
import com.playedit.module.core.config.WxMiniappConfig;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 微信 API 客户端
 */
@Component
public class WxApiClient {

    private static final String CODE2SESSION_URL =
            "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";

    @Resource
    private WxMiniappConfig wxMiniappConfig;

    /**
     * 小程序 code 换取 openid
     */
    public WxSessionResponse code2Session(String code) {
        String url = String.format(CODE2SESSION_URL,
                wxMiniappConfig.getAppId(),
                wxMiniappConfig.getAppSecret(),
                code);
        String body = HttpUtil.get(url);
        WxSessionResponse response = JSONUtil.toBean(body, WxSessionResponse.class);
        if (response.getErrcode() != null && response.getErrcode() != 0) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "微信登录失败：" + response.getErrmsg());
        }
        if (response.getOpenid() == null || response.getOpenid().isBlank()) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "微信登录失败：未获取到 openid");
        }
        return response;
    }
}
