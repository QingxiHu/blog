package com.xxg.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version 1.0
 * @time 2022/10/27 20:53
 * @Author SmallWatermelon
 * @since 1.8
 */

@Controller
@RequestMapping
public class LogoutController {

    @RequestMapping("/logout")
    public String logout() {
        return "logout";
    }
}
