package com.ynu.demo.controller.admin;

import com.ynu.demo.entity.PersonData;
import com.ynu.demo.result.ReturnResult;
import com.ynu.demo.service.AdminUpdService;
import com.ynu.demo.utils.ReturnResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 12:24 2018/6/26
 */
@RestController
@RequestMapping("/admin/upd")
@Api(description = "管理员更新党员信息接口")
public class UpdateController {
    @Autowired
    private AdminUpdService adminUpdService;

    @ApiOperation(value = "更新党员")
    @PostMapping("/update")
    public ReturnResult add(@RequestBody PersonData personData){

        adminUpdService.update(personData);

        return ReturnResultUtil.success();
    }

}
