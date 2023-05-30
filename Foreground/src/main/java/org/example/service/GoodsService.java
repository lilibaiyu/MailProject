package org.example.service;

import org.example.mapper.GoodsMapper;
import org.example.pojo.GoodsInfo;
import org.example.util.PageBean;
import org.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//商品
@Service
public class GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;//自动装填

    //主页面，无条件查询全部商品，分页
    public Result selectGoods(int currentPage,int size){
        return new Result(selectPages(currentPage,size,"%"));//使用%模糊匹配
    }

    //主页面，指定商品名称关键字查询全部商品，分页
    public Result selectGoodsByCondition(int currentPage,int size,String keyword){
        keyword="%"+keyword+"%";
        return new Result(selectPages(currentPage,size,keyword));
    }

    //分页查询
    //返回：商品列表，总条数，页大小，总页数，当前页码
    private PageBean<GoodsInfo> selectPages(int currentPage,int size,String keyword){//开始的位置=(页码数-1)*页大小
        // 查询出该页所有数据
        List<GoodsInfo> list=goodsMapper.findByPage((currentPage-1)*size,size,keyword);//从1计算
        // 查询出有多少条数据
        int totalSize =goodsMapper.findTotalSize(keyword);
        // 计算总页数
        int totalPage =totalSize%size==0?totalSize/size:totalSize/size+1;
        // 当前页
        // 页大小
        // 将分页查询的商品信息封装进PageBean
        return new PageBean<>(list,totalSize,size,totalPage,currentPage);
    }

    //商品详情页
    public Result selectGoodsById(int goods_id){
        return new Result(goodsMapper.selectGoodsById(goods_id));
    }



}
