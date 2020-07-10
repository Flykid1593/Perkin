package com.beidou.tree.service;

import com.beidou.tree.entity.User;

import java.util.List;

public interface UserService {
    List<User> selectAll();
    User selectByName(String userName);
}
