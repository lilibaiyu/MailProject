package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.Manager;

//管理员登录
@Mapper
public interface ManagerLoginMapper {
    //指定管理员id查询登录信息，返回Manager的实例对象
    Manager queryManager(String manager_id);
}
