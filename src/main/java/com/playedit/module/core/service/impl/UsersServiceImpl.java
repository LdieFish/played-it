package com.playedit.module.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.playedit.module.core.entity.Users;
import com.playedit.module.core.service.UsersService;
import com.playedit.module.core.mapper.UsersMapper;
import org.springframework.stereotype.Service;

/**
* @author Acer
* @description 针对表【users(用户表)】的数据库操作Service实现
* @createDate 2026-06-22 16:47:59
*/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
    implements UsersService{

}




