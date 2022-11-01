package com.xxg.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxg.blog.entity.Role;
import com.xxg.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Entity generator.entity.User
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User loadUserByUsername(String username);

    List<Role> getRolesByUid(Long uid);

}




