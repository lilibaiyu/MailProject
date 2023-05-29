package org.example.controller;

import org.example.pojo.GoodsInfo;
import org.example.service.GoodsService;
import org.example.util.PageBean;
import org.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//商品页面
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    //主页面，无条件
    @ResponseBody
    @RequestMapping("/showAll")
    public Result showAllGoods(@RequestParam("currentPage") int currentPage, @RequestParam("size") int size){
        return goodsService.selectGoods(currentPage,size);
    }

    //主页面，查询
    @ResponseBody
    @RequestMapping("/showQuery")
    public Result showQueryGoods(@RequestParam("currentPage") int currentPage, @RequestParam("size") int size, @RequestParam("keyword") String keyword){
        return goodsService.selectGoodsByCondition(currentPage,size,keyword);
    }

    //商品详情页
    @ResponseBody
    @RequestMapping("/showDetail")
    public Result showGoodsById(@RequestParam("goods_id") int goods_id){
        return goodsService.selectGoodsById(goods_id);
    }


}
