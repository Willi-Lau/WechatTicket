package com.lwy.demo.entity;

import lombok.Data;

import java.sql.Date;


@Data
public class Voterecord {

    String openid;
    int cid;
    Date votetime;
}
