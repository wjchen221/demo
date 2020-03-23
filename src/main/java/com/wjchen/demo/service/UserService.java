package com.wjchen.demo.service;

import com.wjchen.demo.dao.UserDao;
import com.wjchen.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface UserService {
    public User save(User user);
}
