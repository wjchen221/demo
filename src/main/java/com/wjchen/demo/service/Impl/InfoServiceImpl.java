package com.wjchen.demo.service.Impl;

import com.wjchen.demo.dao.InfoDao;
import com.wjchen.demo.model.Info;
import com.wjchen.demo.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoDao infoDao;

    @Override
    public Info findOne(String id) {
        return infoDao.findById(id).get();
    }
}
