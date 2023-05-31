package org.example.service;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import org.example.mapper.LoginMapper;
import org.example.mapper.UserInfoMapper;
import org.example.pojo.UserLogin;
import org.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

//用户登录和注册
@Service
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;//自动装填
    @Autowired
    private UserInfoMapper userInfoMapper;//自动装填

    //用户注册
    public Result register(UserLogin userLogin){
        //检查密码是否为空
        if(userLogin.getPassword()==null){
            return new Result("密码不可为空！");
        }
        //检查用户名是否重复
        else if(loginMapper.queryUser(userLogin.getUser_id())!=null){
            return new Result("用户名重复！");
        }
        //新建用户
        else {
            loginMapper.insertUser(userLogin);
            userInfoMapper.addNewUser(userLogin.getUser_id()); //同时在userinfo表中新建条目
            return new Result("注册成功！");

        }
    }

    //用户登录
    public Result login(UserLogin userLogin){
        //先在数据库中查询用户
        UserLogin u=loginMapper.queryUser(userLogin.getUser_id());

        if(u==null){
            return new Result("用户不存在！");
        }
        //检查密码
        else if(!Objects.equals(userLogin.getPassword(), u.getPassword())){
            return new Result("密码错误！");
        }
        else{
            return new Result("登录成功！");
        }

    }






}
