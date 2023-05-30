package org.example.controller;

import org.example.service.CartService;
import org.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


//购物车：加入购物车、查询购物车、删除购物车
@Controller
@RequestMapping("/cart")//一级映射
public class CartController {
    @Autowired
    private CartService cartService;

    //所有结果集都转换为json格式返回给前端
    //加入购物车
    //传入：user_id,goods_id
    //返回：商品已存在于购物车！/加入购物车成功！
    @ResponseBody
    @RequestMapping("/addToCart")//二级映射
    public Result addToCart(@RequestParam("user_id") String user_id, @RequestParam("goods_id") int goods_id){
       //调用service服务层的方法
        return cartService.addToCart(user_id,goods_id);
    }


    //购物车主页面，显示商品
    //传入：user_id
    //返回：购物车中无商品!/购物车中的商品列表
    @ResponseBody
    @RequestMapping("/showCart")//二级映射
    public Result showCart(@RequestParam("user_id") String user_id){
        return cartService.showCart(user_id);
    }

    //删除购物车中商品
    //传入：user_id,goods_id
    //返回：删除过后的购物车数据
    @ResponseBody
    @RequestMapping("/deleteGoods")//二级映射
    public Result deleteGoods(@RequestParam("user_id") String user_id, @RequestParam("goods_id") int goods_id){
        return cartService.deleteGoods(user_id,goods_id);
    }



}
