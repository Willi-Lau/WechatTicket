package com.lwy.demo.mapper;


import com.lwy.demo.entity.Present;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public interface PresentMapper {

    /**
     * 查找所有奖品信息
     */
    @Select("select * from present where aid = #{aid}")
    List<Present> selectallpresent(int aid);

}
