package com.lwy.demo.service.impl;

import com.lwy.demo.entity.Candidate;
import com.lwy.demo.mapper.HomeMapper;
import com.lwy.demo.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {
    //注入
    @Autowired
    private HomeMapper homeMapper;

    @Override
    public int selecttotalpeople(int aid) {
        return homeMapper.selecttotalpeople(aid);
    }

    @Override
    public int selecttotalaccess(int aid) {
        return homeMapper.selecttotalaccess(aid);
    }

    @Override
    public void updatetotalaccess(int aid) {
        homeMapper.updatetotalaccess(aid);
    }

    @Override
    public Date selectactivityendtime(int aid) {
        return homeMapper.selectactivityendtime(aid);
    }

    @Override
    public List<Candidate> selectcandidatebytype(HashMap map) {
        return homeMapper.selectcandidatebytype(map);
    }
}
