package com.ynu.demo.controller;

import com.ynu.demo.Enum.ResultEnum;
import com.ynu.demo.entity.UserRolePermissions;
import com.ynu.demo.exception.MyException;
import com.ynu.demo.result.ReturnResult;
import com.ynu.demo.service.UserService;
import com.ynu.demo.utils.ReturnResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 0:22 2018/7/3
 */
@RestController
@Api(description = "注册接口")
public class RegisterController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "注册")
    @PostMapping("/register")
    public ReturnResult login(UserRolePermissions userRolePermissions) {
        UserRolePermissions temp = userService.save(userRolePermissions);

        if(temp==null){
            throw new MyException(ResultEnum.REGISTER_FAILED);
        }

        return ReturnResultUtil.success();
    }
}
