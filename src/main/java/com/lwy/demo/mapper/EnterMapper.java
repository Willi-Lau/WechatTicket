package com.lwy.demo.mapper;

import com.lwy.demo.entity.Candidate;
import com.lwy.demo.entity.Images;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Repository
public interface EnterMapper {

    /**
     * 查询下一个自增的值
     */
    @Select("SELECT auto_increment FROM information_schema.tables where table_schema='wechatproject' and table_name='candidate';")
    int selectauto_increment();
    /**
     *
     * 存入选手图片表
     */
    @Insert("insert into images(cid,imgurl) values(#{cid},#{imgurl})")
    void insert_immages(Images images);
    /**
     * 存入选手表
     */
    @Insert("insert into candidate(aid,cname,cdeclaration,mobile,sex,address,imgurl,applytime,hots,gifts,tickets) values(#{aid},#{cname},#{cdeclaration},#{mobile},#{sex},#{address},#{imgurl},#{applytime},0,0,0)")
    void insert_candidate(Candidate candidate);
    /**
     * 统计选手表是否有指定cname
     */
    @Select("select count(cid) from candidate where cname = #{cname};")
    int select_countcname(Candidate candidate);
    /**
     * 根据cname 找到cid
     */
    @Select("select cid from candidate where cname = #{cname};")
    int select_findcid(Candidate candidate);
    /**
     * 根据aid 增加活动表的活动人数
     */
    @Update("update activity set totalpeople = totalpeople +1 where aid = #{aid};")
    void update_activitytotalpeople(int aid);

}
