package com.wjchen.demo.base;

import com.wjchen.demo.common.utils.Result;
import org.springframework.data.domain.Pageable;

/**
 * @Author: cwj
 * @Date: 2020/4/6 11:03
 */
public interface BaseService<T> {
    public Result getPage(Pageable page,T entity);
}
