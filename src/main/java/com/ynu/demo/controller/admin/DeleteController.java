package com.ynu.demo.controller.admin;

import com.ynu.demo.result.ReturnResult;
import com.ynu.demo.service.AdminDelService;
import com.ynu.demo.utils.ReturnResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 12:24 2018/6/26
 */
@RestController
@RequestMapping("/admin/del/")
@Api(description = "管理员删除党员信息接口")
public class DeleteController {

    @Autowired
    private AdminDelService adminDelService;

    @ApiOperation(value = "通过ID删除一个党员")
    @PostMapping("delById")
    public ReturnResult delById(@RequestParam("id") Integer id){
        adminDelService.delById(id);
        return ReturnResultUtil.success();
    }


}
