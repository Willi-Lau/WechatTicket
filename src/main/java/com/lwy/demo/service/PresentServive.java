package com.lwy.demo.service;

import com.lwy.demo.entity.Present;

import java.util.List;

public interface PresentServive {

    /**
     * 查找所有的奖品信息
     */
    List<Present> selectallpresent(int aid);
}
