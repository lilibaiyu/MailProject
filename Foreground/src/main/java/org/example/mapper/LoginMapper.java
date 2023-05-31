package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.UserLogin;

//用户登录和注册
@Mapper
public interface LoginMapper {
    //指定用户id查询登录信息，返回UserLogin的实例对象
    UserLogin queryUser(String user_id);

    //指定用户id和密码新建用户
    int insertUser(UserLogin userLogin);

    //指定用户id修改密码
    int updatePassword(String user_id,String password);

    //修改用户禁用与启用权限
    int updateUserUse(String user_id,Integer user_use);


}
