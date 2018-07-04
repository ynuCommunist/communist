package com.ynu.demo.controller;

import com.ynu.demo.result.ReturnResult;
import com.ynu.demo.utils.ReturnResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 11:42 2018/7/3
 */
@RestController
@Api(description = "没有权限")
public class UnauthorizedController {

    @ApiOperation(value = "权限不足")
    @GetMapping("/unauthorized")
    public ReturnResult unauthorized(){
        return ReturnResultUtil.error(50000,"权限不足");
    }
}
