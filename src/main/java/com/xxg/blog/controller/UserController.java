package com.xxg.blog.controller;

import com.xxg.blog.pojo.Users;
import com.xxg.blog.service.UsersService;
import com.xxg.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.0
 * @time 2022/10/21 14:05
 * @Author SmallWatermelon
 * @since 1.8
 */

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UsersService userService;

    @PostMapping("/save")
    public R saveUser(@RequestBody Users user) {
        userService.save(user);
        return R.ok();
    }

    @GetMapping("/all")
    public R allUser() {
        List<Users> list = userService.list();
        return R.ok().put("data", list);
    }
}
