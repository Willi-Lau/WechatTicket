package com.lwy.demo.entity;


import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class Candidate {
    int cid;
    int aid;
    String cname;
    String cdeclaration;
    String mobile;
    String sex;
    String address;
    int hots;
    int gifts;
    int tickets;
    String imgurl;
    Date applytime;
    //一对多
    List<Images> imagesList;


}
