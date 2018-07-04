package com.ynu.demo.exception;

import com.ynu.demo.result.ReturnResult;
import com.ynu.demo.utils.ReturnResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 15:59 2018/6/29
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ReturnResult Handle(Exception e){

        if (e instanceof MyException){
            MyException myException = (MyException) e;
            log.info("[异常]{}",e.getMessage());
            return ReturnResultUtil.error(myException.getCode(),myException.getMessage());

        }else {
            //将系统异常以打印出来
            log.info("[系统异常]",e);
//            e.printStackTrace();
            return ReturnResultUtil.error(-1,"未知错误");
        }

    }
}
