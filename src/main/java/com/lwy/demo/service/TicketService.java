package com.lwy.demo.service;

import com.lwy.demo.entity.Candidate;

import java.util.HashMap;
import java.util.List;



public interface TicketService {

    /**
     * 根据Id查找选手所有信息
     */
    List<Candidate> selectcandidateimages(int cid);
    /**
     * 根据cid 票数加一
     */
    void addticket1(int cid);
    /**
     * 写入日志
     */
    void insertvoterecord(HashMap map);
}
