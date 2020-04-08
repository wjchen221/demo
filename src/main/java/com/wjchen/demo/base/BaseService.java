package com.wjchen.demo.base;

import com.wjchen.demo.common.utils.Result;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: cwj
 * @Date: 2020/4/6 11:03
 */
public interface BaseService<T> {
    /**
     * 保存 与 修改都用 这个方法
     * @param entity
     */
    public T save(T entity);

    /**
     * 删除
     * @param entity
     */
    public void delete(T entity);

    /**
     * 应该是用不到这个方法的
     * @param entity
     */
    public T update(T entity);

    /**
     * 根据id查询实体
     * @param id
     * @return
     */
    public T findById(String id);

    /**
     * 查询所有的数据  -- 正常来说也是用不到的  。到时候重新封装一个分页查询
     * @return
     */
    public List<T> getAll();

    /**
     * 分页查询
     * @param page
     * @param entity
     * @return
     */
    public Result getPage(Pageable page,T entity);
}
