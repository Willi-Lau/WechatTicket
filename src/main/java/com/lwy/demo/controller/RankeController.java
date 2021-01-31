package com.lwy.demo.controller;

import com.lwy.demo.entity.Candidate;
import com.lwy.demo.service.RankeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/RankeController")
@ApiOperation("排名部分")
public class RankeController {

    //注入
    @Autowired
    private RankeService rankeService;

    @ApiOperation("排名 倒叙")
    @RequestMapping(value = "/selectcandidateranke")
    public List<Candidate> selectcandidateranke() {
        return rankeService.selectcandidateranke();
    }
}
