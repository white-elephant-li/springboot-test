package com.ligang.whiteelephant.controller.home;

import com.ligang.whiteelephant.dao.GoodsRepository;
import com.ligang.whiteelephant.entity.home.Goods_all.Goods;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "商品增删改查模块")
@RestController
@RequestMapping("/goods_c")
@ResponseBody
public class GoodsController {
    private GoodsRepository goodsRepository;

    public GoodsController(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @ApiOperation(value = "商品插入", notes = "实现增加")
    @RequestMapping(value = "/insert")
    @ResponseBody
    public Map<String,Object> insertGoods(@RequestBody Goods goods){
        Map<String,Object> result = new HashMap<>();
        goods.setImg("http://ligang666.top/goods-0.jpg");
        goodsRepository.save(goods);
        result.put("data",0);
        return result;
    }

    @ApiOperation(value = "商品更新", notes = "商品各属性一起更新")
    @RequestMapping(value = "/update")
    @ResponseBody
    public Map<String,Object> updateGoods(@RequestBody Goods goods){
        System.out.println(goods.toString());
        Map<String,Object> result = new HashMap<>();
        if (!StringUtils.isEmpty(goodsRepository.selectGoodsById(goods.getId()))){
            goodsRepository.updateNameAndVo(goods.getName(),goods.getPrice(),goods.getVolume(),goods.getisHave(),goods.getisDirect(),goods.getId());
            result.put("data",0);
        }else {
            result.put("data",1);
        }
        return result;
    }

    @ApiOperation(value = "商品删除", notes = "商品各属性一起删除")
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Map<String,Object> deleteGoods(@RequestBody Goods goods){
        Map<String,Object> result = new HashMap<>();
        if (!StringUtils.isEmpty(goodsRepository.selectGoodsById(goods.getId()))){
            goodsRepository.deleteGoodsById(goods.getId());
            result.put("data",0);
        }else {
            result.put("data",1);
        }
        return result;
    }
}
