package com.lwy.demo.controller;


import com.lwy.demo.entity.Present;
import com.lwy.demo.service.PresentServive;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/PresentController")
@ApiOperation("奖励模块")
public class PresentController {

    @Autowired
    private PresentServive presentServive;

    @ApiOperation("获取所有奖励信息")
    @RequestMapping(value = "/selectallpresent",method = RequestMethod.POST)
    public List<Present> selectallpresent(int aid){
        return presentServive.selectallpresent(aid);
    }
}
