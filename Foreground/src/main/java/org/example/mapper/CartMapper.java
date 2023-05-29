package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.Cart;
import org.example.pojo.GoodsInfo;

import java.util.List;

@Mapper
public interface CartMapper {
    Cart findCartByGoodsAndUser(int goods_id,String user_id);
    int addToCart(Cart cart);

    List<GoodsInfo> findGoodsInCart(String user_id);

    int deleteByGoodsAndUser(int goods_id,String user_id);

}
