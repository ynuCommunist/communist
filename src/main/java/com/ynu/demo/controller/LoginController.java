package com.ynu.demo.controller;

import com.ynu.demo.Enum.ResultEnum;
import com.ynu.demo.dto.ReturnObject;
import com.ynu.demo.entity.UserRolePermissions;
import com.ynu.demo.result.ReturnResult;
import com.ynu.demo.utils.ReturnResultUtil;
import com.ynu.demo.utils.TranferUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 22:24 2018/7/2
 */
@RestController
@Api(description = "登录接口")
@Slf4j
public class LoginController {

    @ApiOperation(value = "登录拦截器")
    @GetMapping("/loginInterceptor")
    public ReturnResult login(){
        return ReturnResultUtil.error(2,"未登录");
    }

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public ReturnResult login(@RequestParam(name = "username",defaultValue = "null") String username,
                              @RequestParam(name = "password",defaultValue = "null") String password,
                              @RequestParam(name = "rememberMe",defaultValue = "false") boolean rememberMe,
                              HttpSession session) {
        if(!username.equals("null") && !password.equals("null")){
//            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            UsernamePasswordToken token = new UsernamePasswordToken(username,password,rememberMe);
            Subject subject = SecurityUtils.getSubject();
            try {
                subject.login(token);
                UserRolePermissions userRolePermissions = (UserRolePermissions) subject.getPrincipal();
                log.info("id:"+userRolePermissions.getId()+"-"+userRolePermissions.getRole()+"登录");
                String name = userRolePermissions.getUsername();
                String[] roles = {userRolePermissions.getRole()};
                String[] permissions = TranferUtils.ArrayToString(userRolePermissions.getPermissions());
                return ReturnResultUtil.success(new ReturnObject(name,roles,permissions));
            }catch (Exception e){
                return ReturnResultUtil.error(1,"登录失败");
            }
        }
        return ReturnResultUtil.error(2,"未登录");
    }

    @ApiOperation(value = "登出")
    @PostMapping("/logout")
    public ReturnResult logout(){
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            UserRolePermissions userRolePermissions = (UserRolePermissions) subject.getPrincipal();
            if(userRolePermissions!=null){
                log.info("id:"+userRolePermissions.getId()+"-"+userRolePermissions.getRole()+"登出");

            }
            subject.logout();
        }
        return ReturnResultUtil.success();
    }

    @ApiOperation(value = "获取当前登录用户")
    @GetMapping("/user/info")
    public ReturnResult info(){
        Subject subject = SecurityUtils.getSubject();
        if (subject == null) {
            return ReturnResultUtil.error(ResultEnum.LOGIN_FAIL);
        }
        UserRolePermissions userRolePermissions = (UserRolePermissions) subject.getPrincipal();
        String name = userRolePermissions.getUsername();
        String[] roles = {userRolePermissions.getRole()};
        String[] permissions = TranferUtils.ArrayToString(userRolePermissions.getPermissions());
        return ReturnResultUtil.success(new ReturnObject(name,roles,permissions));
    }
}
