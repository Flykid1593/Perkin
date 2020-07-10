package com.beidou.tree.service;

import com.beidou.tree.entity.User;
import com.beidou.tree.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Perkin
 * @version 1.0
 * @date 2020/7/8 0008 15:06
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;

    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public User selectByName(String userName) {
        return userMapper.selectByName(userName);
    }


}
