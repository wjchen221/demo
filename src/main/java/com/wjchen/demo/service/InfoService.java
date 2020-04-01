package com.wjchen.demo.service;

import com.wjchen.demo.model.Info;
import org.springframework.stereotype.Service;

@Service
public interface InfoService {
    public Info findOne(String id);
}
