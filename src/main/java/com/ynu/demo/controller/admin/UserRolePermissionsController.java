package com.ynu.demo.controller.admin;

import com.ynu.demo.Enum.ResultEnum;
import com.ynu.demo.entity.PersonData;
import com.ynu.demo.entity.UserRolePermissions;
import com.ynu.demo.exception.MyException;
import com.ynu.demo.result.ReturnResult;
import com.ynu.demo.service.UserRolePermissionsService;
import com.ynu.demo.utils.ReturnResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 16:37 2018/7/3
 */
@RestController
@RequestMapping("/admin")
@Api(description = "管理员操作用户接口")
public class UserRolePermissionsController {

    @Autowired
    private UserRolePermissionsService userRolePermissionsService;

    @ApiOperation(value = "得到所有用户")
    @GetMapping("/getAll")
    public ReturnResult getAll(Integer pageNum, Integer pageSize){
        Page<UserRolePermissions> page = userRolePermissionsService.getList(pageNum-1,pageSize);
        return ReturnResultUtil.success(page);
    }

    @ApiOperation(value = "添加用户")
    @PostMapping("/addOneUser")
    public ReturnResult addUser(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                @RequestParam("role") String role,
                                @RequestParam(value = "permissions",required = false,defaultValue = "") String permissions){
        UserRolePermissions userRolePermissions = new UserRolePermissions();
        userRolePermissions.setPermissions(permissions);
        userRolePermissions.setPassword(password);
        userRolePermissions.setRole(role);
        userRolePermissions.setUsername(username);
        userRolePermissionsService.addUser(userRolePermissions);
        return ReturnResultUtil.success();
    }

    @ApiOperation(value = "删除用户")
    @PostMapping("/deleteOneUser")
    public ReturnResult deleteUser(String id){
        userRolePermissionsService.deleteUser(id);
        return ReturnResultUtil.success();
    }

    @ApiOperation(value = "更新用户")
    @PostMapping("/updateOneUser")
    public ReturnResult updateUser(UserRolePermissions userRolePermissions){
        userRolePermissionsService.updateUser(userRolePermissions);
        return ReturnResultUtil.success();
    }

    @ApiOperation(value = "根据角色查找用户")
    @GetMapping("/findAllUser")
    public ReturnResult findAllByRole(Integer pageNum, Integer pageSize, String role){
        Page<UserRolePermissions> page = userRolePermissionsService.findAllByRole(pageNum-1,pageSize,role);
        return ReturnResultUtil.success(page);
    }
}
