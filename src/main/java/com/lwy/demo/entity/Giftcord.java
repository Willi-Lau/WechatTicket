package com.lwy.demo.entity;

import lombok.Data;

import java.sql.Timestamp;


@Data
public class Giftcord {

    int id;
    String openid;
    int cid;
    int lwid;
    int lwcount;
    Timestamp votetime;
}



