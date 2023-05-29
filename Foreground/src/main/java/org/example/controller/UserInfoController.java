package org.example.controller;

import org.example.pojo.UserInfo;
import org.example.service.UserInfoService;
import org.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;



    //用户信息，主页
    @ResponseBody
    @RequestMapping("/showInfo")
    public Result showUserInfo(@RequestParam("user_id") String user_id){
        return userInfoService.selectUserInfo(user_id);
    }


    //修改信息
    //输入：修改后的userInfo类
    //返回：”修改成功“+userInfo
    @ResponseBody
    @RequestMapping("/updateInfo")
    public Result updateUserInfo(@RequestBody UserInfo userInfo){
        return userInfoService.updateUserInfo(userInfo);
    }


    //修改信息
    //输入：用户名+新密码
    //返回：”修改成功“+新密码
    @ResponseBody
    @RequestMapping("/updatePassword")
    public Result changePassword(@RequestParam("user_id") String user_id,@RequestParam("password") String password){
        return userInfoService.updatePassword(user_id,password);
    }


}
