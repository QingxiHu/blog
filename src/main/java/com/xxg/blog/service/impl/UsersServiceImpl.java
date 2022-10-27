package com.xxg.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxg.blog.pojo.Users;
import com.xxg.blog.service.UsersService;
import com.xxg.blog.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */

@Service("UsersService")
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
    implements UsersService {

    @Autowired
    UsersMapper usersMapper;

    @Override
    public boolean login(String username, String password) {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", username).eq("pwd", password);
        boolean exists = usersMapper.exists(wrapper);
        return exists;
    }
}




