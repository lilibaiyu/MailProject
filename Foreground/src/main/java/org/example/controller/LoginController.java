package org.example.controller;

//用户注册与登录

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.example.pojo.UserLogin;
import org.example.service.LoginService;
import org.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")//一级映射
public class LoginController {
    @Autowired
    private LoginService loginService;

    //注册
    //传入：user_id,password
    //返回:密码不可为空！/用户名重复！/注册成功！
    //注册时创建一条userinfo字段
    @ResponseBody
    @RequestMapping("/register")//二级映射
    public Result register(@RequestParam("user_id") String user_id, @RequestParam("password") String password){
        //先实例化用户对象，然后进行注册，默认user_use为1
        UserLogin userLogin=new UserLogin(user_id,password,1);
        return loginService.register(userLogin);
    }

    //登录
    //传入：user_id,password
    //返回:用户不存在！/密码错误！/登录成功！
    @ResponseBody
    @RequestMapping("/login")//二级映射
    public Result login(@RequestParam("user_id") String user_id, @RequestParam("password") String password){
        //先实例化用户对象，默认user_use为1，然后进行检查登录
        UserLogin userLogin=new UserLogin(user_id,password,1);
        return loginService.login(userLogin);
    }



}
