package com.lwy.demo.controller;


import com.lwy.demo.entity.Candidate;
import com.lwy.demo.entity.Images;
import com.lwy.demo.service.EnterService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/EnterController")
@ApiOperation("注册页面")
public class EnterController {
    //注入Service
    @Autowired
    private EnterService enterService;

//    注册，以及上传文件照片
    @RequestMapping(value = "/upload")
    @ApiOperation("注册")
    public synchronized void Enterinf(Candidate person,MultipartFile [] uploFiles) throws IOException, InterruptedException {
        //设置路径
        String springbootsrc = System.getProperty("user.dir");
        //获取选手编号，判断数据库中下一个编号是多少
        int nextid = enterService.selectauto_increment();
        //获取当前时间
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        person.setApplytime(java.sql.Date.valueOf(df.format(date)));

        //上传的第一张为封面
        //封面名字
        String imgurl  = UUID.randomUUID().toString().substring(0,10)+"img";

        //拼接上传路径
        String s = new StringBuffer(springbootsrc + "\\src\\main\\vue\\vue_cli_wechat\\src\\assets\\").toString();
        String url_candidate = s + "Candidate\\" + imgurl+".jpg";
        //给person 路径
        person.setImgurl(imgurl);
        person.setAid(1);

        //查找这个名字是否注册过
        //根据cname 查找cid 没有则是新创建，有则用之前的
        int cid = enterService.select_countcname(person);

        if(cid != 0){
            //执行添加 candidate
            nextid = enterService.select_findcid(person);

        }
        else {

            enterService.insert_candidate(person);
            cid = enterService.select_countcname(person);
            //活动人数进行增加
            enterService.update_activitytotalpeople(person.getAid());
        }
        //上传封面
        uploFiles[0].transferTo(new File(url_candidate));
        Images images = new Images();
        images.setCid(nextid);
         images.setImgurl(imgurl);
        //执行添加 iamges
        enterService.insert_images(images);







    }
}
