package com.atguigu.springcloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fuguofeng
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private T        data;
    private Integer  code;
    private String   message;

    public CommonResult(Integer code, String message){
        this(null, code, message);
    }

}
