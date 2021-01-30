package com.lwy.demo.mapper;


import com.lwy.demo.entity.Candidate;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

@Repository
public interface HomeMapper {

    /**
     * 根据活动id返回活动的人数
     */
    @Select("select totalpeople from activity where aid =#{aid}")
    int selecttotalpeople(int aid);
    /**
     * 根据aid 返回活动访问量
     */
    @Select("select totalaccess from activity where aid = #{aid}")
     int selecttotalaccess(int aid);
    /**
     * 把活动访问量+1
     */
    @Update("update activity set totalaccess = totalaccess+1 where aid = #{aid}")
    void updatetotalaccess(int aid);
    /**
     * 返回活动时间
     */
    @Select("select endtime from activity where aid = #{aid}")
    Date selectactivityendtime(int aid);
    /**
     * 根据条件查找 返回信息
     */
    List<Candidate> selectcandidatebytype(HashMap map);
}
