package com.xxg.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxg.blog.entity.User;
import com.xxg.blog.mapper.UserMapper;
import com.xxg.blog.service.UserService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

}




