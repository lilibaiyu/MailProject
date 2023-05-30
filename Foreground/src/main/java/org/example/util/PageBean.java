package org.example.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//分页
//使用lombok进行自动构造get、set、equals、hashCode、canEqual、toString、类的全参构造方法、类的无参构造方法
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<T>{
    private List<T> data;//商品信息列表
    private int totalSize;//总条数
    private int pageSize;//页大小
    private int totalPage;//总页数
    private int currentPage;//当前页码
}
