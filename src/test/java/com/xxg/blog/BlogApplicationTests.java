package com.xxg.blog;

import com.xxg.blog.mapper.UserMapper;
import com.xxg.blog.entity.User;
import com.xxg.blog.service.UserService;
import com.xxg.blog.utils.R;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class BlogApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;


    @Test
    void contextLoads() {
    }

    @Test
    void allUser() {
        List<User> list = userService.list();

        System.out.println(R.ok().put("data", list));
    }


}
