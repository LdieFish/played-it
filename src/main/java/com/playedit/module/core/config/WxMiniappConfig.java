package com.playedit.module.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信小程序配置
 */
@Data
@Component
@ConfigurationProperties(prefix = "wx.miniapp")
public class WxMiniappConfig {

    private String appId;

    private String appSecret;
}
