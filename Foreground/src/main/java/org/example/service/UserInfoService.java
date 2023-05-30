package org.example.service;

import org.example.mapper.LoginMapper;
import org.example.mapper.UserInfoMapper;
import org.example.pojo.UserInfo;
import org.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//用户信息
@Service
public class UserInfoService {
    @Autowired
    private LoginMapper loginMapper;//自动装填
    @Autowired
    private UserInfoMapper userInfoMapper;//自动装填

    //根据id查找用户信息
    public Result selectUserInfo(String user_id){
        return new Result(userInfoMapper.selectUserInfoById(user_id));
    }

    //更新用户信息
    public Result updateUserInfo(UserInfo userInfo){
        userInfoMapper.updateUserInfo(userInfo);
        return new Result("修改成功！",userInfo);
    }

    //修改用户密码
    public Result updatePassword(String user_id,String password){
        loginMapper.updatePassword(user_id,password);
        return new Result("修改成功！",password);
    }

}
