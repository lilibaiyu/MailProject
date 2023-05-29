package org.example.service;

import org.example.mapper.GoodsMapper;
import org.example.pojo.GoodsInfo;
import org.example.util.PageBean;
import org.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    //主页面，全部商品，分页
    public Result selectGoods(int currentPage,int size){
        return new Result(selectPages(currentPage,size,"%"));
    }
    //主页面，全部商品，查询，分页
    public Result selectGoodsByCondition(int currentPage,int size,String keyword){
        keyword="%"+keyword+"%";
        return new Result(selectPages(currentPage,size,keyword));
    }

    private PageBean<GoodsInfo> selectPages(int currentPage,int size,String keyword){//(页码数-1)*页大小
        // 查询出该页所有数据
        List<GoodsInfo> list=goodsMapper.findByPage((currentPage-1)*size,size,keyword);//从1计算
        // 查询出有多少条数据
        int totalSize =goodsMapper.findTotalSize(keyword);
        // 总页数
        int totalPage =totalSize%size==0?totalSize/size:totalSize/size+1;
        // 当前页
        // 页大小
        return new PageBean<>(list,totalSize,size,totalPage,currentPage);
    }

    //商品详情页
    public Result selectGoodsById(int goods_id){
        return new Result(goodsMapper.selectGoodsById(goods_id));
    }



}
