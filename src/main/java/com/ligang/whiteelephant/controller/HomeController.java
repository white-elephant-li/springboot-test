package com.ligang.whiteelephant.controller;

import com.ligang.whiteelephant.dao.ActivityRepository;
import com.ligang.whiteelephant.dao.GoodsRepository;
import com.ligang.whiteelephant.dao.SecondsRepository;
import com.ligang.whiteelephant.dao.SwiperRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/home")
@CrossOrigin

@Api(tags = "app主页")
public class HomeController {

    private  SwiperRepository swiperRepository;
    private  ActivityRepository activityRepository;
    private  SecondsRepository secondsRepository;
    private GoodsRepository goodsRepository;

    public HomeController(SwiperRepository swiperRepository,
                          ActivityRepository activityRepository,
                          SecondsRepository secondsRepository,
                            GoodsRepository goodsRepository) {
        this.swiperRepository = swiperRepository;
        this.activityRepository = activityRepository;
        this.secondsRepository = secondsRepository;
        this.goodsRepository = goodsRepository;
    }

    @GetMapping(value = "/swiper")
    @ResponseBody
    @ApiOperation(value = "获取swiper的图像地址")
    public Map<String,Object> icon_swiper(){
        Map<String,Object> icon = new HashMap<>();
        Map<String,Object> result = new HashMap<>();

        icon.put("list",swiperRepository.selectSwiper());
        result.put("state",0);
        result.put("data",icon);

        return result;
    }

    @GetMapping(value = "/activity")
    @ResponseBody
    public Map<String,Object> icon_activity(){
        Map<String,Object> icon = new HashMap<>();
        Map<String,Object> result = new HashMap<>();

        icon.put("list",activityRepository.selectActivity());
        result.put("state",0);
        result.put("data",icon);

        return result;
    }

    @GetMapping(value = "/seconds")
    @ResponseBody
    public Map<String,Object> icon_seconds(){
        Map<String,Object> icon = new HashMap<>();
        Map<String,Object> result = new HashMap<>();

        icon.put("list",secondsRepository.selectSeconds());
        result.put("state",0);
        result.put("data",icon);

        return result;
    }

    @GetMapping(value = "/goods")
    @ResponseBody
    public Map<String,Object> get_all_goods(){
        Map<String,Object> icon = new HashMap<>();
        Map<String,Object> result = new HashMap<>();
//        System.out.println(goodsRepository.selectGoods());

        icon.put("list",goodsRepository.selectGoods());
        result.put("state",0);
        result.put("data",icon);

        return result;
    }



}
