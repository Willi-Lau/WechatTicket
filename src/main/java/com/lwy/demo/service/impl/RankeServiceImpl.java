package com.lwy.demo.service.impl;

import com.lwy.demo.mapper.RankeMapper;
import com.lwy.demo.service.RankeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RankeServiceImpl implements RankeService {

    @Autowired
    private RankeMapper rankeMapper;
}
