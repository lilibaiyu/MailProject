package org.example.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<T>{
    private List<T> data;
    private int totalSize;
    private int pageSize;
    private int totalPage;
    private int currentPage;
}
