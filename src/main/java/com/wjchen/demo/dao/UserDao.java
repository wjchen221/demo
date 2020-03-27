package com.wjchen.demo.dao;

import com.wjchen.demo.base.BaseDao;
import com.wjchen.demo.model.User;

public interface UserDao extends BaseDao<User> {
    public User findByUsername(String username);
}

