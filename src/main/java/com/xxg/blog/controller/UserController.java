package com.xxg.blog.controller;

import com.xxg.blog.entity.User;
import com.xxg.blog.service.UserService;
import com.xxg.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    UserService userService;

    @RequestMapping("/hello")
    public String hello() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        System.out.println("user = " + user.getUsername());
        System.out.println("user = " + authentication.getAuthorities());
        new Thread(() -> {
            Authentication authentication1 = SecurityContextHolder.getContext().getAuthentication();
            System.out.println("子线程" + authentication1);
        }).start();
        return "hello";
    }

    @PostMapping("/save")
    public R saveUser(@RequestBody User user) {
        userService.save(user);
        return R.ok();
    }

    @GetMapping("/all")
    public R allUser() {
        List<User> list = userService.list();
        return R.ok().put("data", list);
    }

    @GetMapping("/all2")
    public R allUser2() {
        List<User> list = userService.list();
        return R.ok().put("data", list);
    }
}
