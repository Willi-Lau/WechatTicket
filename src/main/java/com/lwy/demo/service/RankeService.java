package com.lwy.demo.service;

import com.lwy.demo.entity.Candidate;

import java.util.List;

public interface RankeService {
    /**
     * 获取排名
     *
     */
    List<Candidate> selectcandidateranke();
}
