package com.xxg.blog.service;

import com.xxg.blog.pojo.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */

public interface UsersService extends IService<Users> {

    boolean login(String username, String password);
}
