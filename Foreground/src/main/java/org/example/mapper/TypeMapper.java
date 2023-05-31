package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.Type;

import java.util.List;

@Mapper
public interface TypeMapper {
    //新建商品类型
    int addNewType(Type type);

    //指定类型名字查询信息
    // 分页查找
    List<Type> findByPage(int start,int size,String keyword);

    //指定类型名字返回数量
    int findTotalSize(String keyword);

    //根据类型id查询类型信息
    Type findTypeById(Integer type_id);

    //根据类型名字查询类型信息
    Type findTypeByName(String type_name);

    //修改类型名字
    int updateTypeName(Type type);

    //修改类型禁用启用情况
    int updateTypeUse(String type_name,Integer type_use);

    //根据类型名字删除类型
    int deleteByTypeName(String type_name);

//    int getLastInsertId();
}
