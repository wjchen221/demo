package com.wjchen.demo.base;

import org.omg.CORBA.INTERNAL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseDao<T> extends JpaRepository<T, Integer> {
}
