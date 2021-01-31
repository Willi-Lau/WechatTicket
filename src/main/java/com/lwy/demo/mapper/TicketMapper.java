package com.lwy.demo.mapper;


import com.lwy.demo.entity.Candidate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface TicketMapper {
    /**
     * 根据id 查找选手所有的信息
     */
    List<Candidate> selectcandidateimages(int cid);
    /**
     * 根据cid 票数加1
     */
    @Update("update candidate set tickets = tickets + 1 ,hots = hots +5 where cid = #{cid};")
    void addticket1(int cid);
    /**
     * 写入投票日志
     */
    @Insert("insert into voterecord(openid,cid,votetime) values(#{openid},#{cid},#{votetime})")
    void insertvoterecord(HashMap map);
}
