package com.lwy.demo.mapper;


import com.lwy.demo.entity.Gift;
import com.lwy.demo.entity.Giftcord;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface GiftMapper {
    /**
     * 从后台查找所有的礼物信息并返回
     */
    @Select("select * from gift")
    List<Gift> selectallgift();
    /**
     * 指定礼物数量-1
     */
    @Update("update gift set count = count - 1 where lwid = #{lwid} ")
    void cutgift(int lwid);
    /**
     * 写入礼物日志
     */
    @Insert("insert into giftrecord(openid,cid,lwid,lwcount,votetime) values(#{openid},#{cid},#{lwid},1,#{votetime})" )
    void insertgiftcord(Giftcord giftcord);
    /**
     * 增加选手点数
     */
    @Update("update candidate set gifts = gifts + #{dianshu} where cid = #{cid}")
    void insertandidategift(HashMap map);
}
