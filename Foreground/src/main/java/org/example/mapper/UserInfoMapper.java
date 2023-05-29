package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.UserInfo;

@Mapper
public interface UserInfoMapper {
    int addNewUser(String user_id);
    UserInfo selectUserInfoById(String user_id);

    int updateUserInfo(UserInfo userInfo);
}
