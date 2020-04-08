package com.wjchen.demo.base;

import com.wjchen.demo.common.utils.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.Entity;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: cwj
 * @Date: 2020/4/6 11:07
 */
public abstract class BaseServiceImpl<T> implements BaseService<T>{

    public abstract BaseDao<T> getDao();

    @Override
    public T save(T entity) {
        return getDao().save(entity);
    }

    @Override
    public void delete(T entity) {
        getDao().delete(entity);
    }

    @Override
    public T update(T entity) {
        //该方法没用
        return null;
    }

    @Override
    public T findById(String id) {
        return (T) getDao().findById(id);
    }

    @Override
    public List<T> getAll() {
        return getDao().findAll();
    }

    /**
     * 分页查询的条件
     * @param cb
     * @param root
     * @return
     */
    public abstract List<Predicate> getParams(CriteriaBuilder cb,Root<T> root,T entity);

    @Override
    public Result getPage(Pageable page,T entity) {
        Page<T> list = getDao().findAll(new Specification<T>() {
            private static final long serialVersionUID = 1L;
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = getParams(cb,root,entity);
                Predicate[] pre = new Predicate[list.size()];
                query.where(list.toArray(pre));
                return query.getRestriction();
            }
        }, page);
        return new Result("0","查询成功",list.getContent(),list.getTotalElements());
    }
}
