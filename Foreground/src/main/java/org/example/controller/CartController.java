package org.example.controller;

import org.example.service.CartService;
import org.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


//购物车
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    //加入购物车
    //返回：商品已存在于购物车/加入购物车成功
    @ResponseBody
    @RequestMapping("/addToCart")
    public Result addToCart(@RequestParam("user_id") String user_id, @RequestParam("goods_id") int goods_id){
       return cartService.addToCart(user_id,goods_id);
    }


    //购物车，显示商品
    //返回：购物车为空/数据
    @ResponseBody
    @RequestMapping("/showCart")
    public Result showCart(@RequestParam("user_id") String user_id){
        return cartService.showCart(user_id);
    }

    //删除购物车中商品
    //返回：删除过后的购物车数据
    @ResponseBody
    @RequestMapping("/deleteGoods")
    public Result deleteGoods(@RequestParam("user_id") String user_id, @RequestParam("goods_id") int goods_id){
        return cartService.deleteGoods(user_id,goods_id);
    }



}
