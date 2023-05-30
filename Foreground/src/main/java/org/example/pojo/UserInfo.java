package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//使用lombok进行自动构造get、set、equals、hashCode、canEqual、toString、类的全参构造方法、类的无参构造方法
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private String user_id;
    private String nickname;//昵称、别称
    private String gender;
    private int phone;
    private String email;

}
