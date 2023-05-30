package org.example.util;

import lombok.AllArgsConstructor;
import lombok.Data;

//封装状态，没加状态码
//使用lombok进行自动构造get、set、equals、hashCode、canEqual、toString、类的全参构造方法
@Data
@AllArgsConstructor
public class Result {
    private String message;//状态的提示信息
    private Object data;//状态的返回对象，详细信息

    public Result(String message){
        this.message=message;
    }

    public Result(Object data){
        this.data=data;
    }

}
