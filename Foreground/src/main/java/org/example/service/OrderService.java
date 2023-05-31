package org.example.service;

import org.example.mapper.CartMapper;
import org.example.mapper.GoodsMapper;
import org.example.mapper.OrderMapper;
import org.example.pojo.Cart;
import org.example.pojo.Order;
import org.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    //添加新的订单
    public Result addNewOrder(String user_id,String address){
        //首先通过用户id得到所有商品列表
        List<Cart> list=cartMapper.findByUserId(user_id);
        String goods_id_list="";//商品id列表，初始化为空串
        Double price=0.0;//总价钱
        //遍历list
        for(Cart cart:list){
            price = price + goodsMapper.selectGoodsById(cart.getGoods_id()).getUnit_price();//计算总价
            goods_id_list = goods_id_list + cart.getGoods_id() + ",";//连接商品列表
        }
        //得到当前时间
        String order_time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        //新建order对象实例
        Order order=new Order(user_id,goods_id_list,order_time,address,price);
        //传入数据库
        int i=orderMapper.addNewOrder(order);
        if (i > 0){
            return new Result("创建成功！",order);
        }
        else {
            return new Result("创建失败！");
        }
    }

    //根据用户id查询已有的订单信息
    public Result findByUserId(String user_id){
        if(orderMapper.findByUserId(user_id)!=null){
            return new Result(orderMapper.findByUserId(user_id));
        }
        else {
            return new Result("该用户没有订单！");
        }
    }
}
