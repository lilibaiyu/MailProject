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

//用户信息：显示用户主页信息、修改用户信息、修改用户密码
@Controller
@RequestMapping("/userInfo")//一级映射
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;//自动装填



    //显示指定用户信息，主页
    //传入：user_id
    //返回：用户UserInfo对象的相关信息
    @ResponseBody
    @RequestMapping("/showInfo")//二级映射
    public Result showUserInfo(@RequestParam("user_id") String user_id){
        return userInfoService.selectUserInfo(user_id);
    }


    //修改信息
    //输入：修改后的userInfo类，以json形式传入，user_id,nickname,gender,phone,email必须齐全
    //返回：”修改成功！“+userInfo用户信息
    @ResponseBody
    @RequestMapping("/updateInfo")
    public Result updateUserInfo(@RequestBody UserInfo userInfo){
        return userInfoService.updateUserInfo(userInfo);
    }


    //修改密码
    //输入：用户名user_id+新密码password
    //返回：”修改成功！“+新密码
    @ResponseBody
    @RequestMapping("/updatePassword")
    public Result changePassword(@RequestParam("user_id") String user_id,@RequestParam("password") String password){
        return userInfoService.updatePassword(user_id,password);
    }


}
