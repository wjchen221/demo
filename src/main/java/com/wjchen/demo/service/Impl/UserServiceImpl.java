package com.wjchen.demo.service.Impl;

import com.wjchen.demo.base.BaseDao;
import com.wjchen.demo.base.BaseServiceImpl;
import com.wjchen.demo.dao.UserDao;
import com.wjchen.demo.model.User;
import com.wjchen.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Component(value="userService")
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getById(String id) {
        return userDao.getOne(id);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public List<User> getList() {
        return userDao.findAll();
    }

    @Override
    public BaseDao getDao() {
        return userDao;
    }

    @Override
    public List<Predicate> getParams(CriteriaBuilder cb, Root<User> root,User user) {
        List<Predicate> list = new ArrayList<>();
        if(user.getUsername()!=null) {
            list.add(cb.equal(root.get("username").as(String.class),user.getUsername()));
        }
        return list;
    }
}
