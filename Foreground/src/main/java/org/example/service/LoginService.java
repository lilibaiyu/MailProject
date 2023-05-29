package org.example.service;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import org.example.mapper.LoginMapper;
import org.example.mapper.UserInfoMapper;
import org.example.pojo.UserLogin;
import org.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    //用于注册
    public Result register(UserLogin userLogin){
        if(userLogin.getPassword()==null){
            return new Result("密码不可为空");
        }
        else if(loginMapper.queryUser(userLogin.getUser_id())!=null){
            return new Result("用户名重复");
        }
        else {
            loginMapper.insertUser(userLogin);
            userInfoMapper.addNewUser(userLogin.getUser_id()); //在userinfo表中新建条目
            return new Result("注册成功");

        }
    }

    //用于登录
    public Result login(UserLogin userLogin){
        UserLogin u=loginMapper.queryUser(userLogin.getUser_id());

        if(u==null){
            return new Result("用户不存在");
        }
        else if(userLogin.getPassword()==u.getPassword()){
            return new Result("密码错误");
        }
        else{
            return new Result("登录成功");
        }

    }






}
