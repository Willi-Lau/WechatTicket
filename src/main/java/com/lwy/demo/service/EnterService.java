package com.lwy.demo.service;

import com.lwy.demo.entity.Candidate;
import com.lwy.demo.entity.Images;
import org.springframework.beans.factory.annotation.Autowired;

public interface EnterService {
    /**
     * 返回下一个自增值
     */
    int selectauto_increment();
    /**
     * 存入选手图片表
     */
     void insert_images(Images images);
    /**
     * 存入选手信息
     */
    void insert_candidate(Candidate candidate);
    /**
     * 统计个数
     */
    int select_countcname(Candidate candidate);
    /**
     * 根据名字查找id
     */
    int select_findcid(Candidate candidate);
    /**
     * 根据aid 增加活动人数
     */
    void update_activitytotalpeople(int aid);
}

