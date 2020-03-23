package com.wjchen.demo.service.Impl;

import com.wjchen.demo.base.BaseDao;
import com.wjchen.demo.base.BaseServiceImpl;
import com.wjchen.demo.model.User;
import com.wjchen.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private BaseDao UserDao;

    @Override
    protected BaseDao getDao() {
        return UserDao;
    }
}
