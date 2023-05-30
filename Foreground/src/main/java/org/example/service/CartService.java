package org.example.service;

import org.example.mapper.CartMapper;
import org.example.pojo.Cart;
import org.example.pojo.GoodsInfo;
import org.example.util.PageBean;
import org.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartMapper cartMapper;//使用Autowired自动装填

    //加入购物车
    public Result addToCart(String user_id, int goods_id){
        //加入购物车之前先查询是否存在
        if(cartMapper.findCartByGoodsAndUser(goods_id,user_id)!=null){
            return new Result("商品已存在于购物车！");
        }
        else {
            cartMapper.addToCart(new Cart(goods_id,user_id));
            return new Result("加入购物车成功！");
        }

    }

    //购物车主页面
    public Result showCart(String user_id){
        List<GoodsInfo> list=cartMapper.findGoodsInCart(user_id);
        if(list==null){
            return new Result("购物车中无商品!");
        }
        else {
            //返回：购物车中的商品列表
            return new Result("购物车",list);
        }

    }

    //删除商品
    public Result deleteGoods(String user_id, int goods_id){
        cartMapper.deleteByGoodsAndUser(goods_id,user_id);
        List<GoodsInfo> list=cartMapper.findGoodsInCart(user_id);
        if(list==null){
            return new Result("购物车中无商品！");
        }
        else {
            //返回：删除过后的购物车数据
            return new Result("购物车",list);
        }
    }


}
