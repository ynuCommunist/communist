package com.ynu.demo.controller.admin;

import com.ynu.demo.entity.PersonData;
import com.ynu.demo.result.ReturnResult;
import com.ynu.demo.service.AdminAddService;
import com.ynu.demo.utils.ReturnResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 12:24 2018/6/26
 */
@RestController
@RequestMapping("/admin/add")
@Api(description = "管理员添加党员信息接口")
public class AddController {
    @Autowired
    private AdminAddService adminAddService;

    @ApiOperation(value = "添加一个党员")
    @PostMapping("/addOne")
    public ReturnResult add(@RequestBody PersonData personData){
        adminAddService.add(personData);

        return ReturnResultUtil.success();
    }
}
