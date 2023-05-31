package org.example.service;

import org.example.mapper.LoginMapper;
import org.example.mapper.UserInfoMapper;
import org.example.pojo.GoodsInfo;
import org.example.pojo.UserInfo;
import org.example.util.PageBean;
import org.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketingService {
    @Autowired
    private UserInfoMapper userInfoMapper;//用户信息
    @Autowired
    private LoginMapper loginMapper;//用户登录和权限控制

    //分页查询所有用户信息
    public Result selectUsers(int currentPage,int size){
        return new Result(selectPages(currentPage,size,"%"));//使用%模糊匹配
    }

    //分页查询
    //返回：用户列表，总条数，页大小，总页数，当前页码
    private PageBean<UserInfo> selectPages(int currentPage, int size, String keyword){//开始的位置=(页码数-1)*页大小
        // 查询出该页所有数据
        List<UserInfo> list=userInfoMapper.findByPage((currentPage-1)*size,size,keyword);//从1计算
        // 查询出有多少条数据
        int totalSize =userInfoMapper.findTotalSize(keyword);
        // 计算总页数
        int totalPage =totalSize%size==0?totalSize/size:totalSize/size+1;
        // 当前页
        // 页大小
        // 将分页查询的商品信息封装进PageBean
        return new PageBean<>(list,totalSize,size,totalPage,currentPage);
    }

    //用户的启用与禁用
    public Result updateUserUse(String user_id,Integer user_use){
        //先判断一下用户是否存在
        if(loginMapper.queryUser(user_id)!=null){
            int i= loginMapper.updateUserUse(user_id,user_use);
            if(i > 0){
                return new Result("修改成功！");
            }
            else {
                return new Result("修改失败！");
            }
        }
        else {
            return new Result("该用户不存在！");
        }
    }
}
