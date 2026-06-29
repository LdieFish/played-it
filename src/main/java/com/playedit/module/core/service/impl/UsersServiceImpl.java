package com.playedit.module.core.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.playedit.common.auth.JwtUtils;
import com.playedit.common.constant.UserConstant;
import com.playedit.common.exception.BusinessException;
import com.playedit.common.exception.ErrorCode;
import com.playedit.common.exception.ThrowUtils;
import com.playedit.module.core.client.WxApiClient;
import com.playedit.module.core.client.WxSessionResponse;
import com.playedit.module.core.dto.WxLoginRequest;
import com.playedit.module.core.entity.Users;
import com.playedit.module.core.mapper.UsersMapper;
import com.playedit.module.core.service.UsersService;
import com.playedit.module.core.vo.LoginUserVO;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 用户 Service 实现
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
        implements UsersService {

    @Resource
    private WxApiClient wxApiClient;

    @Resource
    private JwtUtils jwtUtils;

    @Override
    public LoginUserVO wxLogin(WxLoginRequest request) {
        ThrowUtils.throwIf(request == null || StrUtil.isBlank(request.getCode()),
                ErrorCode.PARAMS_ERROR, "code 不能为空");

        WxSessionResponse session = wxApiClient.code2Session(request.getCode());
        Users user = lambdaQuery()
                .eq(Users::getOpenid, session.getOpenid())
                .eq(Users::getDeleted, 0)
                .one();

        if (user == null) {
            user = new Users();
            user.setOpenid(session.getOpenid());
            user.setUnionid(session.getUnionid());
            user.setNickname(request.getNickname());
            user.setAvatarUrl(request.getAvatarUrl());
            user.setUserRole(UserConstant.DEFAULT_ROLE);
            user.setSteamVerified(0);
            user.setDeleted(0);
            save(user);
        } else {
            boolean needUpdate = false;
            if (StrUtil.isNotBlank(session.getUnionid()) && !session.getUnionid().equals(user.getUnionid())) {
                user.setUnionid(session.getUnionid());
                needUpdate = true;
            }
            if (StrUtil.isNotBlank(request.getNickname())) {
                user.setNickname(request.getNickname());
                needUpdate = true;
            }
            if (StrUtil.isNotBlank(request.getAvatarUrl())) {
                user.setAvatarUrl(request.getAvatarUrl());
                needUpdate = true;
            }
            if (needUpdate) {
                updateById(user);
            }
        }

        LoginUserVO loginUserVO = toLoginUserVO(user);
        loginUserVO.setToken(jwtUtils.createToken(user.getId(), user.getUserRole()));
        return loginUserVO;
    }

    @Override
    public LoginUserVO getLoginUserVO(Long userId) {
        ThrowUtils.throwIf(userId == null, ErrorCode.NOT_LOGIN_ERROR);
        Users user = getById(userId);
        ThrowUtils.throwIf(user == null, ErrorCode.NOT_FOUND_ERROR, "用户不存在");
        return toLoginUserVO(user);
    }

    private LoginUserVO toLoginUserVO(Users user) {
        LoginUserVO vo = new LoginUserVO();
        BeanUtils.copyProperties(user, vo);
        return vo;
    }
}
