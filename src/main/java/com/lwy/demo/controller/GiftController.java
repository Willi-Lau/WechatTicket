package com.lwy.demo.controller;


import com.lwy.demo.entity.Gift;
import com.lwy.demo.entity.Giftcord;
import com.lwy.demo.service.GiftService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/GiftController")
@ApiOperation("礼物部分")
public class GiftController {

    @Autowired
    private GiftService giftService;


    @ApiOperation("返回所有的礼物信息")
    @RequestMapping(value = "/selectallgift",method = RequestMethod.POST)
    public List<Gift> selectallgift() {
        return giftService.selectallgift();
    }
    @ApiOperation("赠送礼物")
    @RequestMapping(value = "/givegift",method = RequestMethod.POST)
    public void givegift(int lwid,int cid,String ip,int dianshu) {
            //指定礼物数量 -1
            giftService.cutgift(lwid);
            //添加礼物到选手信息  写入礼物点数
        HashMap map = new HashMap();
        map.put("cid",cid);
        map.put("dianshu",dianshu);
        giftService.insertandidategift(map);
            //写入礼物日志
        Giftcord giftcord = new Giftcord();
        giftcord.setCid(cid);
        giftcord.setLwid(lwid);
        giftcord.setOpenid(ip);
        giftcord.setVotetime(new Timestamp(new Date().getTime()));

        giftService.insertgiftcord(giftcord);
    }



}
