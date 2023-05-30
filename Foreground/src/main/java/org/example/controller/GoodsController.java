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

//商品页面：无条件查询所有商品、指定商品名称关键字查询商品、查询商品详情页
@Controller
@RequestMapping("/goods")//一级映射
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    //所有结果集都转换为json格式返回给前端
    //主页面，无条件查询全部商品
    //传入：currentPage：当前页码，size：页的大小即需要查询的记录条数
    //返回：商品列表，总条数，页大小，总页数，当前页码
    @ResponseBody
    @RequestMapping("/showAll")//二级映射
    public Result showAllGoods(@RequestParam("currentPage") int currentPage, @RequestParam("size") int size){
        return goodsService.selectGoods(currentPage,size);
    }

    //主页面，指定商品名称关键字查询全部商品
    //传入：currentPage：当前页码，size：页的大小即需要查询的记录条数，keyword：商品名称关键字
    //返回：商品列表，总条数，页大小，总页数，当前页码
    @ResponseBody
    @RequestMapping("/showQuery")
    public Result showQueryGoods(@RequestParam("currentPage") int currentPage, @RequestParam("size") int size, @RequestParam("keyword") String keyword){
        return goodsService.selectGoodsByCondition(currentPage,size,keyword);
    }

    //商品详情页
    //传入：goods_id：商品id
    //返回：指定id的商品信息
    @ResponseBody
    @RequestMapping("/showDetail")
    public Result showGoodsById(@RequestParam("goods_id") int goods_id){
        return goodsService.selectGoodsById(goods_id);
    }


}
