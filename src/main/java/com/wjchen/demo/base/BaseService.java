package com.wjchen.demo.base;

import java.util.List;

public interface BaseService<T> {
    /**
     * 保存 与 修改都用 这个方法
     * @param entity
     */
    public void save(T entity);

    /**
     * 删除
     * @param entity
     */
    public void delete(T entity);

    /**
     * 应该是用不到这个方法的
     * @param entity
     */
    public void update(T entity);

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

}
