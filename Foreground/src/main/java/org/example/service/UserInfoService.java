package org.example.service;

import org.example.mapper.LoginMapper;
import org.example.mapper.UserInfoMapper;
import org.example.pojo.UserInfo;
import org.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    //根据id查找用户信息
    public Result selectUserInfo(String user_id){
        return new Result(userInfoMapper.selectUserInfoById(user_id));
    }

    public Result updateUserInfo(UserInfo userInfo){
        userInfoMapper.updateUserInfo(userInfo);
        return new Result("修改成功",userInfo);
    }

    public Result updatePassword(String user_id,String password){
        loginMapper.updatePassword(user_id,password);
        return new Result("修改成功",password);
    }

}
