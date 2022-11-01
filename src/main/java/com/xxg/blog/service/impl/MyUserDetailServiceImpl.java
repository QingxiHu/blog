package com.xxg.blog.service.impl;

import com.xxg.blog.entity.User;
import com.xxg.blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @version 1.0
 * @time 2022/10/30 16:42
 * @Author SmallWatermelon
 * @since 1.8
 */

@Service
public class MyUserDetailServiceImpl implements UserDetailsService {

    private final UserMapper userMapper;

    @Autowired
    public MyUserDetailServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userMapper.loadUserByUsername(username);
        if (ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        user.setRoles(userMapper.getRolesByUid(user.getUserId()));

        return user;
    }
}
