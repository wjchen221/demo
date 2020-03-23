package com.wjchen.demo.base;

import java.util.List;
import java.util.Optional;

public class BaseServiceImpl<T> implements BaseService<T> {

    private BaseDao<T> baseDao;
    public void setBaseDao(BaseDao<T> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public void save(T entity) {
        baseDao.save(entity);
    }

    @Override
    public void delete(T entity) {
        baseDao.delete(entity);
    }

    @Override
    public void update(T entity) {
        //该方法没用
    }

    @Override
    public T findById(String id) {
        return (T) baseDao.findById(id);
    }

    @Override
    public List<T> getAll() {
        return baseDao.findAll();
    }
}
