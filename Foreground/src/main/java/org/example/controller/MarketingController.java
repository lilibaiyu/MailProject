package org.example.controller;

import org.example.service.MarketingService;
import org.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//营销经理管理用户
@Controller
@RequestMapping("/marketing")
public class MarketingController {
    @Autowired
    private MarketingService marketingService;

    //查询所有用户信息，分页展示
    //传入：currentPage：当前页码，size：页的大小即需要查询的记录条数
    //返回：用户列表，总条数，页大小，总页数，当前页码
    @ResponseBody
    @RequestMapping("/showAllUsers")
    public Result showAllUsers(@RequestParam("currentPage") int currentPage,@RequestParam("size") int size){
        return marketingService.selectUsers(currentPage, size);
    }

    //用户的启用与禁用权限控制
    //传入：user_id：用户id, user_use：修改后的use值
    //返回：修改成功！/修改失败！/该用户不存在！
    @ResponseBody
    @RequestMapping("/updateUserUse")
    public Result updateUserUse(String user_id,Integer user_use){
        return marketingService.updateUserUse(user_id, user_use);
    }
}
