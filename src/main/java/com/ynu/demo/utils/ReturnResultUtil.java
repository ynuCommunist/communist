package com.ynu.demo.utils;

import com.ynu.demo.Enum.ResultEnum;
import com.ynu.demo.result.ReturnResult;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 19:27 2018/6/25
 */
public class ReturnResultUtil {

    public static ReturnResult success(Object object){
        ReturnResult returnResult = new ReturnResult();
        returnResult.setData(object);
        returnResult.setCode(0);
        returnResult.setMsg("成功");

        return returnResult;
    }

    public static ReturnResult success(){
        return success(null);
    }

    public static ReturnResult error(Integer code, String msg) {
        ReturnResult returnResult = new ReturnResult();
        returnResult.setCode(code);
        returnResult.setMsg(msg);
        return returnResult;
    }

    public static ReturnResult error(ResultEnum resultEnum) {
        ReturnResult returnResult = new ReturnResult();
        returnResult.setCode(resultEnum.getCode());
        returnResult.setMsg(resultEnum.getMessage());
        return returnResult;
    }

}
