package org.example.util;

import lombok.AllArgsConstructor;
import lombok.Data;

//封装状态，没加状态码
@Data
@AllArgsConstructor
public class Result {
    private String message;
    private Object data;

    public Result(String message){
        this.message=message;
    }

    public Result(Object data){
        this.data=data;
    }

}
