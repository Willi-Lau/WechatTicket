package com.lwy.demo.entity;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class Gift {

    int lwid;
    String lwimg;
    int aid;
    String lwname;
    int dianshu;
    BigDecimal price;
    int count;


}
