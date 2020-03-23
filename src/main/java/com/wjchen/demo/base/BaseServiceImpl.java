package com.wjchen.demo.base;

import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

    protected abstract BaseDao getDao();

    @Override
    public void save(T entity) {
        getDao().save(entity);
    }

    @Override
    public void delete(T entity) {
        getDao().delete(entity);
    }

    @Override
    public void update(T entity) {
        //该方法没用
    }

    @Override
    public T findById(String id) {
        return (T) getDao().findById(id);
    }

    @Override
    public List<T> getAll() {
        return getDao().findAll();
    }
}
