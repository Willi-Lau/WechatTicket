package com.lwy.demo.controller;


import com.lwy.demo.entity.Candidate;
import com.lwy.demo.service.TicketService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/TicketController")
@ApiOperation("投票模块")
public class TicketController {
   //注入
    @Autowired
    private TicketService ticketService;


    @ApiOperation("返回指定id选手所有的的信息")
    @RequestMapping(value = "/selectcandidateimages")
    public List<Candidate> selectcandidateimages(int cid) {
        return ticketService.selectcandidateimages(cid);
    }

    @ApiOperation("投票")
    @RequestMapping(value = "/addticket")
    public void addticket(int cid,String ip) {
        //更改选手表把票数加1
         ticketService.addticket1(cid);

        //写入日志
        java.sql.Date date = new java.sql.Date(new Date().getTime());
        HashMap map = new HashMap();
        map.put("votetime",date);
        map.put("cid",cid);
        map.put("openid",ip);
        ticketService.insertvoterecord(map);

    }



}
