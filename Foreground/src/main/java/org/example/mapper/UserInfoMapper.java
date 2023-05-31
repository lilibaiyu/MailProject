package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.UserInfo;

import java.util.List;

//用户信息
@Mapper
public interface UserInfoMapper {
    //指定用户id新建用户
    int addNewUser(String user_id);

    //指定用户id查询用户信息,返回UserInfo实例对象
    UserInfo selectUserInfoById(String user_id);

    //指定用户id修改用户信息
    int updateUserInfo(UserInfo userInfo);

    //指定用户id查询用户信息
    List<UserInfo> findByPage(int start,int size,String user_id);

    //指定用户id返回数量
    int findTotalSize(String keyword);
}
