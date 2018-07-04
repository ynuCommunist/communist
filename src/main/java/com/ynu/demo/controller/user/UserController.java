package com.ynu.demo.controller.user;

import com.ynu.demo.result.ReturnResult;
import com.ynu.demo.service.UserService;
import com.ynu.demo.utils.ReturnResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 0:07 2018/7/3
 */
@RestController
@RequestMapping("/user")
@Api(description = "普通用户接口")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查找所有党员")
    @GetMapping("/findall")
    public ReturnResult findAll(@RequestParam("pageNum") Integer pageNum,
                                @RequestParam("pageSize") Integer pageSize,
                                @RequestParam(name = "title", defaultValue = "null") String title,
                                @RequestParam(name = "city", defaultValue = "null") String city,
                                @RequestParam(name = "sort", defaultValue = "ASC") String sort,
                                @RequestParam(name = "sortBy", defaultValue = "id") String sortBy) {

        return ReturnResultUtil.success(userService.getList(pageNum-1, pageSize, title, city, sort, sortBy));
    }
}
