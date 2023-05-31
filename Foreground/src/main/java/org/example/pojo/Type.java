package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//商品类型
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Type {
    private Integer type_id;
    private String type_name;
    private Integer type_use;
}
