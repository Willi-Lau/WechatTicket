package com.lwy.demo.entity;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import lombok.Data;


@Data
public class Present {
    int pid;
    int aid;
    String pimg;
    String pname;
    int pcount;
    String level;
}
