package org.example.controller;

import org.example.service.ManagerLoginService;
import org.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//管理员登录
@Controller
@RequestMapping("/manager")//一级映射
public class ManagerLoginController {
    @Autowired
    private ManagerLoginService managerLoginService;//自动填充


    //管理员登录
    //传入：manager_id,password
    //返回：管理员不存在！/密码错误！/该管理员已经被禁用，无法登录！/登录成功！+manager实例对象
    @ResponseBody
    @RequestMapping("/login")//二级映射
    public Result login(@RequestParam("manager_id") String manager_id,@RequestParam("password") String password){
        return managerLoginService.login(manager_id,password);
    }
}
