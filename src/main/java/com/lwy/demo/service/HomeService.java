package com.lwy.demo.service;

import com.lwy.demo.entity.Candidate;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

public interface HomeService {
    /**
     * 根据aic 返回参赛人数
     */
    int selecttotalpeople(int aid);
    /**
     * 根据aid 返回活动访问量
     */
    int selecttotalaccess(int aid);
    /**
     * 把活动访问量+1
     */
    void updatetotalaccess(int aid);
    /**
     * 获取活动结束时间
     */
    Date selectactivityendtime(int aid);
    /**
     * 条件查询
     */
    List<Candidate> selectcandidatebytype(HashMap map);
}
