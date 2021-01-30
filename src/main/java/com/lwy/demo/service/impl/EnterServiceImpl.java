package com.lwy.demo.service.impl;

import com.lwy.demo.entity.Candidate;
import com.lwy.demo.entity.Images;
import com.lwy.demo.mapper.EnterMapper;
import com.lwy.demo.service.EnterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class EnterServiceImpl implements EnterService {
    //注入Mapper
    @Autowired
    private EnterMapper enterMapper;


    @Override
    public int selectauto_increment() {
        return enterMapper.selectauto_increment();
    }

    @Override
    public void insert_images(Images images) {
        enterMapper.insert_immages(images);
    }

    @Override
    public void insert_candidate(Candidate candidate) {
            enterMapper.insert_candidate(candidate);
    }

    @Override
    public int select_countcname(Candidate candidate) {
        return enterMapper.select_countcname(candidate);
    }

    @Override
    public int select_findcid(Candidate candidate) {
        return enterMapper.select_findcid(candidate);
    }

    @Override
    public void update_activitytotalpeople(int aid) {
        enterMapper.update_activitytotalpeople(aid);
    }
}
