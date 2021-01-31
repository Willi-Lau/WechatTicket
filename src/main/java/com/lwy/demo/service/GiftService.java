package com.lwy.demo.service;

import com.lwy.demo.entity.Gift;
import com.lwy.demo.entity.Giftcord;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

public interface GiftService {

    /**
     * 从后台查找所有的礼物信息并返回
     */

    List<Gift> selectallgift();
    /**
     * 礼物数 -1
     */
    void cutgift(int lwid);
    /**
     * 写入日志
     */
    void insertgiftcord(Giftcord giftcord);
    /**
     * 增加选手点数
     */
    void insertandidategift(HashMap map);
}
