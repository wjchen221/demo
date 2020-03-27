package com.wjchen.demo.service.Impl;

import com.wjchen.demo.dao.UserDao;
import com.wjchen.demo.model.User;
import com.wjchen.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User getById(String id) {
        return userDao.getOne(id);
    }
}
