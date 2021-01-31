package com.lwy.demo.service.impl;


import com.lwy.demo.entity.Present;
import com.lwy.demo.mapper.PresentMapper;
import com.lwy.demo.service.PresentServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PreserviceImpl implements PresentServive {

    //注入Mapper
    @Autowired
    private PresentMapper presentMapper;

    @Override
    public List<Present> selectallpresent(int aid) {
        return presentMapper.selectallpresent(aid);
    }
}
