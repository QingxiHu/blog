package com.xxg.blog.controller;

import com.xxg.blog.mapper.UsersMapper;
import com.xxg.blog.service.UsersService;
import com.xxg.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @time 2022/10/17 16:14
 * @Author SmallWatermelon
 * @since 1.8
 */

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    UsersService usersService;

    @GetMapping("/login")
    public R login(String username, String password) {
        username = "abc";
        password = "123456";
        usersService.login(username, password);

        return R.ok();
    }
}
