package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//订单
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String user_id;
    private String goods_id_list;//以字符串的形式存储所有的商品id
    private String order_time;
    private String address;
    private Double price;
}
