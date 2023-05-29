package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.UserLogin;

@Mapper
public interface LoginMapper {
    UserLogin queryUser(String user_id);

    int insertUser(UserLogin userLogin);

    int updatePassword(String user_id,String password);


}
