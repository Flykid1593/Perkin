package com.beidou.tree.mapper;

import com.beidou.tree.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> selectAll();
    User selectById(@Param("id") Integer id);
    User selectByName(@Param("username")String username);
}
