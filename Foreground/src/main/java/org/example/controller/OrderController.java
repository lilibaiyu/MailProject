package org.example.controller;

import org.example.service.OrderService;
import org.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    //新建订单
    //传入：user_id,address
    //返回：创建成功！+ order实例对象/创建失败！
    @ResponseBody
    @RequestMapping("/addNewOrder")
    public Result addNewOrder(@RequestParam("user_id") String user_id,@RequestParam("address") String address){
        return orderService.addNewOrder(user_id, address);
    }

    //查询订单
    //传入：user_id
    //返回：订单order列表/该用户没有订单！
    @ResponseBody
    @RequestMapping("/findOrder")
    public Result findByUserId(@RequestParam("user_id") String user_id){
        return orderService.findByUserId(user_id);
    }
}
