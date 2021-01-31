package com.lwy.demo.service.impl;

import com.lwy.demo.entity.Gift;
import com.lwy.demo.entity.Giftcord;
import com.lwy.demo.mapper.GiftMapper;
import com.lwy.demo.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;


@Service
@Transactional
public class GiftServiceImpl implements GiftService {

    @Autowired
    private GiftMapper giftMapper;


    @Override
    public List<Gift> selectallgift() {
        return giftMapper.selectallgift();
    }

    @Override
    public void cutgift(int lwid) {
        giftMapper.cutgift(lwid);
    }

    @Override
    public void insertgiftcord(Giftcord giftcord) {
          giftMapper.insertgiftcord(giftcord);
    }

    @Override
    public void insertandidategift(HashMap map) {
          giftMapper.insertandidategift(map);
    }
}
