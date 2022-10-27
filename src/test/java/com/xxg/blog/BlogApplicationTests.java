package com.xxg.blog;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxg.blog.mapper.ArticleCategoryReferencedMapper;
import com.xxg.blog.mapper.ArticleMapper;
import com.xxg.blog.mapper.UsersMapper;
import com.xxg.blog.pojo.Article;
import com.xxg.blog.pojo.ArticleCategoryReferenced;
import com.xxg.blog.pojo.Users;
import com.xxg.blog.service.UsersService;
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
    UsersMapper userMapper;

    @Autowired
    UsersService userService;


    @Test
    void contextLoads() {
    }

    @Test
    void allUser() {
        List<Users> list = userService.list();

        System.out.println(R.ok().put("data", list));
    }


}
