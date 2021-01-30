package com.lwy.demo.controller;


import com.github.pagehelper.PageHelper;
import com.lwy.demo.entity.Candidate;
import com.lwy.demo.service.HomeService;
import io.swagger.annotations.ApiOperation;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@CrossOrigin
@RestController
@RequestMapping(value = "/HomeController")
@ApiOperation("主页面")
public class HomeController {
    //注入
    @Autowired
    private HomeService homeService;

    @ApiOperation("根据aid查看参加活动的人数")
    @RequestMapping(value = "/selecttotalpeople",method = RequestMethod.POST)
    public int selecttotalpeople(int aid){
        return homeService.selecttotalpeople(aid);
    }
    @ApiOperation("根据aid将总访问量加1 根据aid查看总访问量")
    @RequestMapping(value = "/updateselecttotalaccess",method = RequestMethod.POST)
    public int selecttotalaccess(int aid){
        //先加以1
             homeService.updatetotalaccess(aid);
             //再返回数量
          return homeService.selecttotalaccess(aid);
    }
    @ApiOperation("查询活动结束时间")
    @RequestMapping(value = "/selectactivityendtime",method = RequestMethod.POST)
    public ConcurrentHashMap<String, Object> selectactivityendtime(int aid) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = homeService.selectactivityendtime(aid);
        Date now1 = new Date();
//计算活动结束还有多久
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date endtime = format.parse(sdf.format(date).toString());
        Date now = format.parse(sdf.format(now1).toString());
        long between = endtime.getTime() - now.getTime();
        long day = between / (24 * 60 * 60 * 1000);
        long hour = (between / (60 * 60 * 1000) - day * 24);
        long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long b = 1;
        long c = 0;
        //再map 中存储 天数，小时，分钟，秒，并返回 处理并发
        ConcurrentHashMap<String,Object> map = new ConcurrentHashMap<>();
            map.put("day",day);
            map.put("hour",hour);
            map.put("min",min);
            map.put("s",s);
            if (between >0){
                map.put("between","大于");
            }
            else {
                map.put("between","小于");
            }
        return map;
    }
    @ApiOperation("条件查询 分页查询 Github pagehelper")
    @RequestMapping(value = "/selectcandidatebytype",method = RequestMethod.POST)
    public List<Candidate> selectcandidatebytype(@RequestParam(defaultValue = "") String inf,
                                                 @RequestParam(defaultValue = "all")String type,
                                                 @RequestParam(defaultValue = "1") int pageNo,
                                                 @RequestParam(defaultValue = "10") int pageSize

    ){
        //juc 防止并发
        HashMap<String,String> map = new HashMap<>();
        map.put("inf",inf);
        map.put("type",type);
        //分页
        PageHelper.startPage(pageNo,pageSize);
        return homeService.selectcandidatebytype(map);

    }

}
