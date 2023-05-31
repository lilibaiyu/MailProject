package org.example.service;

import org.example.mapper.TypeMapper;
import org.example.pojo.GoodsInfo;
import org.example.pojo.Type;
import org.example.util.PageBean;
import org.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialistService {
    @Autowired
    private TypeMapper typeMapper;//自动填充

    //新建类型
    //注意主键type_id是自增长类型
    public Result addNewType(Type type){
        //先判断数据库中是否已经存在该类型
        if(typeMapper.findTypeByName(type.getType_name())==null){
            //在数据库新建类型
            Integer i=typeMapper.addNewType(type);
            if(i > 0){
                //从数据库传回新建的类型
                Type newType=typeMapper.findTypeByName(type.getType_name());
                return new Result("创建成功！",newType);
            }else{
                return new Result("创建失败！");
            }
        }
        else{
            return new Result("该类型已经存在！");
        }
    }

    //修改类型的名字
    //传入：type_id:要修改的类型id，type_name:修改后的类型名称
    public Result updateTypeName(Integer type_id,String type_name){
        Type type=typeMapper.findTypeById(type_id);
        //设置新的名称
        type.setType_name(type_name);
        Integer i=typeMapper.updateTypeName(type);
        if(i > 0){
            return new Result("修改成功！");
        }else{
            return new Result("修改失败！");
        }
    }

    //修改类型的禁用启用情况
    public Result updateTypeUse(String type_name,Integer type_use){
        Integer i=typeMapper.updateTypeUse(type_name,type_use);
        if(i > 0){
            return new Result("修改成功！");
        }else {
            return new Result("修改失败！");
        }
    }

    //根据类型名字删除类型
    public Result deleteByTypeName(String type_name){
        Integer i=typeMapper.deleteByTypeName(type_name);
        if(i > 0){
            return new Result("删除成功！");
        }else {
            return new Result("删除失败！");
        }
    }


    //无条件查询全部类型，分页
    public Result selectTypes(int currentPage,int size){
        return new Result(selectPages(currentPage,size,"%"));//使用%模糊匹配
    }

    //指定类型名称关键字查询全部类型，分页
    public Result selectTypesByCondition(int currentPage,int size,String keyword){
        keyword="%"+keyword+"%";
        return new Result(selectPages(currentPage,size,keyword));
    }

    //分页查询
    //返回：类型列表、总条数、页大小、总页数、当前页码
    private PageBean<Type> selectPages(int currentPage, int size, String keyword){//开始的位置=(页码数-1)*页大小
        // 查询出该页所有数据
        List<Type> list=typeMapper.findByPage((currentPage-1)*size,size,keyword);//从1计算
        // 查询出有多少条数据
        int totalSize =typeMapper.findTotalSize(keyword);
        // 计算总页数
        int totalPage =totalSize%size==0?totalSize/size:totalSize/size+1;
        // 当前页
        // 页大小
        // 将分页查询的商品信息封装进PageBean
        return new PageBean<>(list,totalSize,size,totalPage,currentPage);
    }
}
