package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.Cart;
import org.example.pojo.GoodsInfo;

import java.util.List;

//购物车
@Mapper
public interface CartMapper {
    //指定商品id和用户id查询购物车
    Cart findCartByGoodsAndUser(int goods_id,String user_id);

    //指定用户id查询购物车
    List<Cart> findByUserId(String user_id);

    //指定商品id和用户id插入新的购物车
    int addToCart(Cart cart);

    //指定用户id查询购物车所有商品
    List<GoodsInfo> findGoodsInCart(String user_id);

    //指定用户id和商品id删除购物车中的商品
    int deleteByGoodsAndUser(int goods_id,String user_id);

}
