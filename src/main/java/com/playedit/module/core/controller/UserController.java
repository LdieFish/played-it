package com.playedit.module.core.controller;

import com.playedit.common.auth.LoginUserHolder;
import com.playedit.common.response.ApiResponse;
import com.playedit.common.response.ResultUtils;
import com.playedit.module.core.dto.WxLoginRequest;
import com.playedit.module.core.service.UsersService;
import com.playedit.module.core.vo.LoginUserVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Tag(name = "用户模块")
public class UserController {

    @Resource
    private UsersService usersService;

    @PostMapping("/login/wx")
    @Operation(summary = "微信小程序登录")
    public ApiResponse<LoginUserVO> wxLogin(@RequestBody WxLoginRequest request) {
        return ResultUtils.success(usersService.wxLogin(request));
    }

    @GetMapping("/me")
    @Operation(summary = "获取当前登录用户")
    public ApiResponse<LoginUserVO> getLoginUser() {
        return ResultUtils.success(usersService.getLoginUserVO(LoginUserHolder.getUserId()));
    }
}
