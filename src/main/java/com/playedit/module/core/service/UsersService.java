package com.playedit.module.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.playedit.module.core.dto.WxLoginRequest;
import com.playedit.module.core.entity.Users;
import com.playedit.module.core.vo.LoginUserVO;

/**
 * 用户 Service
 */
public interface UsersService extends IService<Users> {

    /**
     * 微信小程序登录
     */
    LoginUserVO wxLogin(WxLoginRequest request);

    /**
     * 获取当前登录用户信息
     */
    LoginUserVO getLoginUserVO(Long userId);
}
