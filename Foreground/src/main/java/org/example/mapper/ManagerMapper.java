package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.Manager;

import java.util.List;

//管理员信息
@Mapper
public interface ManagerMapper {
    //分页查询所有管理员
    List<Manager> findByPage(int start,int size,String keyword);

    //指定管理员id返回数量
    int findTotalSize(String keyword);

    //根据指定管理员id查询所有信息
    Manager findById(String manager_id);

    //插入新的管理员
    int addNewManager(Manager manager);

    //修改管理员信息（密码或者类型或者权限）
    int updateManagerInfo(Manager manager);

    //指定id删除管理员
    int deleteManagerById(String manager_id);
}
