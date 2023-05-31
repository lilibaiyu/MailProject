package org.example.controller;

import org.example.pojo.GoodsInfo;
import org.example.service.GoodsService;
import org.example.util.PageBean;
import org.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    @RequestMapping("/showAllGoods")//二级映射
    public Result showAllGoods(@RequestParam("currentPage") int currentPage, @RequestParam("size") int size){
        return goodsService.selectGoods(currentPage,size);
    }

    //主页面，指定商品名称关键字查询全部商品
    //传入：currentPage：当前页码，size：页的大小即需要查询的记录条数，keyword：商品名称关键字
    //返回：商品列表，总条数，页大小，总页数，当前页码
    @ResponseBody
    @RequestMapping("/showQueryGoods")
    public Result showQueryGoods(@RequestParam("currentPage") int currentPage, @RequestParam("size") int size, @RequestParam("keyword") String keyword){
        return goodsService.selectGoodsByCondition(currentPage,size,keyword);
    }

    //指定类型查询商品信息
    //传入：type_id
    //返回：商品列表
    @ResponseBody
    @RequestMapping("/showTypeGoods")
    public Result showTypeGoods(@RequestParam("type_id") Integer type_id){
        return goodsService.selectGoodsByType(type_id);
    }

    //商品详情页
    //传入：goods_id：商品id
    //返回：指定id的商品信息
    @ResponseBody
    @RequestMapping("/showDetail")
    public Result showGoodsById(@RequestParam("goods_id") int goods_id){
        return goodsService.selectGoodsById(goods_id);
    }

    //新建商品
    //传入：json格式的goodsInfo对象(goods_name,unit_price,image,description,type_id)
    //不需要传入goods_id，自动增长
    //返回：新建成功！+goodsInfo实例对象/新建失败！/该商品已经存在！
    @ResponseBody
    @RequestMapping("/addNewGood")
    public Result addNewGood(@RequestBody GoodsInfo goodsInfo){
        return goodsService.addNewGood(goodsInfo);
    }

    //更新商品
    //传入：json格式的goodsInfo对象(goods_id必须正确,goods_name,unit_price,image,description,type_id)
    //返回：修改成功！/修改失败！
    @ResponseBody
    @RequestMapping("/updateGoodsInfo")
    public Result updateGoodsInfo(@RequestBody GoodsInfo goodsInfo){
        return goodsService.updateGoodsInfo(goodsInfo);
    }

    //删除商品
    //传入：goods_name商品名称
    //返回：删除成功！/删除失败！
    @ResponseBody
    @RequestMapping("/deleteGoods")
    public Result deleteGoodsByName(@RequestParam("goods_name") String goods_name){
        return goodsService.deleteGoodsByName(goods_name);
    }

}
