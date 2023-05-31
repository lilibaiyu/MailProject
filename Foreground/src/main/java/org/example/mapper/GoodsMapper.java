package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.GoodsInfo;

import java.util.List;

//商品
@Mapper
public interface GoodsMapper {
    //指定商品名字查询商品信息
    //start：开始的位置
    //size：查询的记录条数
    List<GoodsInfo> findByPage(int start, int size,String keyword);

    //指定商品名字返回数量
    int findTotalSize(String keyword);

    //指定商品类型返回商品信息
    List<GoodsInfo> selectGoodsByType(Integer type_id);

    //指定商品id查询商品信息
    GoodsInfo selectGoodsById(int goods_id);

    //指定商品名称查询商品信息
    GoodsInfo selectGoodsByName(String goods_name);

    //新建商品
    int addNewGood(GoodsInfo goodsInfo);

    //更新商品
    int updateGoodsInfo(GoodsInfo goodsInfo);

    //指定商品名称删除商品
    int deleteGoodsByName(String goods_name);



}
