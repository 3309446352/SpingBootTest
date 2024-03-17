package com.example.demo.User.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.User.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2024-03-04 23:16:00
 */
@Mapper
public interface UserMapper extends  BaseMapper<User>{
    @Select("select * from user where username=#{username}")
    User findUserByUSerUserName(String username);

    default User findUserByUserName(String username){
        return findUserByUSerUserName(username);
    }
}

