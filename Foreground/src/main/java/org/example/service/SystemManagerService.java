package org.example.service;

import org.example.mapper.ManagerMapper;
import org.example.pojo.Manager;
import org.example.util.PageBean;
import org.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemManagerService {
    @Autowired
    private ManagerMapper managerMapper;

    //分页查询所有管理员
    public Result selectManagers(int currentPage, int size){
        return new Result(selectPages(currentPage,size,"%"));//使用%模糊匹配
    }

    //分页查询
    //返回：管理员列表，总条数，页大小，总页数，当前页码
    private PageBean<Manager> selectPages(int currentPage, int size, String keyword){//开始的位置=(页码数-1)*页大小
        // 查询出该页所有数据
        List<Manager> list=managerMapper.findByPage((currentPage-1)*size,size,keyword);//从1计算
        // 查询出有多少条数据
        int totalSize =managerMapper.findTotalSize(keyword);
        // 计算总页数
        int totalPage =totalSize%size==0?totalSize/size:totalSize/size+1;
        // 当前页
        // 页大小
        // 将分页查询的商品信息封装进PageBean
        return new PageBean<>(list,totalSize,size,totalPage,currentPage);
    }

    //插入新的管理员
    public Result addNewManager(Integer manager_type,String manager_id,String password){
        //先判断管理员是否存在
        if(managerMapper.findById(manager_id)==null){
            //先实例化一个manager对象，默认use值为1
            Manager manager=new Manager(manager_type,manager_id,password,1);
            int i=managerMapper.addNewManager(manager);
            if(i > 0){
                return new Result("添加成功！",manager);
            }
            else {
                return new Result("添加失败！");
            }
        }
        else {
            return new Result("该管理员已经存在！");
        }
    }

    //修改管理员信息
    public Result updateManagerInfo(Manager manager){
        //先判断id是否存在
        if(managerMapper.findById(manager.getManager_id())!=null){
            int i=managerMapper.updateManagerInfo(manager);
            if(i > 0){
                return new Result("修改成功！");
            }
            else {
                return new Result("修改失败！");
            }
        }
        else {
            return new Result("该管理员不存在！");
        }
    }

    //删除管理员
    public Result deleteManager(String manager_id){
        //先判断id是否存在
        if(managerMapper.findById(manager_id)!=null){
            int i=managerMapper.deleteManagerById(manager_id);
            if(i > 0){
                return new Result("删除成功！");
            }
            else {
                return new Result("删除失败！");
            }
        }
        else {
            return new Result("该管理员不存在！");
        }
    }
}
