package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.Order;

import java.util.List;

@Mapper
public interface OrderMapper {
    //添加新的订单
    int addNewOrder(Order order);

    //根据指定的用户id查询订单
    List<Order> findByUserId(String user_id);
}
