package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsInfo {
    private Integer goods_id;
    private String goods_name;
    private Double unit_price;
    private String image;
    private String description;
}
