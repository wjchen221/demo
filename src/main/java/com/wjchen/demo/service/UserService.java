package com.wjchen.demo.service;

import com.wjchen.demo.base.BaseService;
import com.wjchen.demo.dao.UserDao;
import com.wjchen.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends BaseService<User> {
    public User save(User user);

    public User getById(String id);

    public User findByUsername(String username);

    public List<User> getList();
}
