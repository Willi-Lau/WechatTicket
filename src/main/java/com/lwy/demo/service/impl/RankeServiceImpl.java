package com.lwy.demo.service.impl;

import com.lwy.demo.entity.Candidate;
import com.lwy.demo.mapper.RankeMapper;
import com.lwy.demo.service.RankeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class RankeServiceImpl implements RankeService {

    @Autowired
    private RankeMapper rankeMapper;

    @Override
    public List<Candidate> selectcandidateranke() {
        return rankeMapper.selectcandidateranke();
    }
}
