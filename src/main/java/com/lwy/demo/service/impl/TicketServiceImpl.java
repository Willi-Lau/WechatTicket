package com.lwy.demo.service.impl;

import com.lwy.demo.entity.Candidate;
import com.lwy.demo.mapper.TicketMapper;
import com.lwy.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;


@Service
@Transactional
public class TicketServiceImpl implements TicketService {
    //注入
    @Autowired
    private TicketMapper ticketMapper;



    @Override
    public List<Candidate> selectcandidateimages(int cid) {
        return ticketMapper.selectcandidateimages(cid);
    }

    @Override
    public void addticket1(int cid) {
          ticketMapper.addticket1(cid);
    }

    @Override
    public void insertvoterecord(HashMap map) {
        ticketMapper.insertvoterecord(map);
    }


}
