package com.lwy.demo.mapper;


import com.lwy.demo.entity.Candidate;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankeMapper {

/**
 * 根据礼物数排行
 */
 @Select("select * from candidate ORDER BY gifts desc;")
 List<Candidate> selectcandidateranke();
}
