package org.example.service;

import org.example.mapper.ManagerLoginMapper;
import org.example.pojo.Manager;
import org.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//管理员登录
@Service
public class ManagerLoginService {
    @Autowired
    private ManagerLoginMapper managerLoginMapper;//自动装填
    
    //管理员登录
    public Result login(String manager_id,String password){
        Manager manager=managerLoginMapper.queryManager(manager_id);
        if(manager==null){
            return new Result("管理员不存在！");
        } else if (!password.equals(manager.getPassword())) {
            return new Result("密码错误！");
        }
        else if (manager.getManager_use()==0){
            return new Result("该管理员已经被禁用，无法登录！");
        }
        else {
            return new Result("登录成功！",manager);
        }
    }
}
