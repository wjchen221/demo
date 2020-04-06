package com.wjchen.demo.base;

import com.wjchen.demo.common.utils.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseDao<T> extends JpaRepository<T, String> {
    Page<T> findAll(Specification<T> specification, Pageable pageable);
}
