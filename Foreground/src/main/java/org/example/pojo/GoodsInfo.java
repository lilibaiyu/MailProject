package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//使用lombok进行自动构造get、set、equals、hashCode、canEqual、toString、类的全参构造方法、类的无参构造方法
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsInfo {
    private Integer goods_id;
    private String goods_name;
    private Double unit_price;
    private String image;
    private String description;
    private Integer type_id;//商品类型
}
