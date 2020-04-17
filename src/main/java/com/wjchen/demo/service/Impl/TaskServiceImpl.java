package com.wjchen.demo.service.Impl;

import com.wjchen.demo.base.BaseDao;
import com.wjchen.demo.base.BaseServiceImpl;
import com.wjchen.demo.dao.TaskDao;
import com.wjchen.demo.model.Task;
import com.wjchen.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author
 * @date 2020/04/17 15:55
 */
@Service
public class TaskServiceImpl extends BaseServiceImpl<Task> implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public BaseDao<Task> getDao() {
        return taskDao;
    }

    @Override
    public List<Predicate> getParams(CriteriaBuilder cb, Root<Task> root, Task entity) {
        return null;
    }
}
