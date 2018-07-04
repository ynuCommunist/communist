package com.ynu.demo.exception;

import com.ynu.demo.Enum.ResultEnum;
import lombok.Getter;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 15:26 2018/6/29
 */
@Getter
public class MyException extends RuntimeException{
    private Integer code;

    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public MyException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
