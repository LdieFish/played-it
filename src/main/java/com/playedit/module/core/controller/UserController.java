package com.playedit.module.core.controller;

import com.playedit.module.core.service.UsersService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Tag(name = "用户模块")
public class UserController {

    @Resource
    private UsersService usersService;

}
