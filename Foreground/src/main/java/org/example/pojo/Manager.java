package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//管理员
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manager {
    private Integer manager_type;//管理员类型，1是销售专员，2是营销经理，3是系统管理员
    private String manager_id;
    private String password;
    private Integer manager_use;

}
