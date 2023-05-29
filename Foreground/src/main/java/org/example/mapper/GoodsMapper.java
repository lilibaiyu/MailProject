package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.GoodsInfo;

import java.util.List;

@Mapper
public interface GoodsMapper {

    List<GoodsInfo> findByPage(int start, int size,String keyword);
    int findTotalSize(String keyword);
    GoodsInfo selectGoodsById(int goods_id);




}
