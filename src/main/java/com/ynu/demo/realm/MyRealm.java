package com.ynu.demo.realm;

import com.ynu.demo.entity.UserRolePermissions;
import com.ynu.demo.service.LoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 10:24 2018/6/30
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private LoginService loginService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        UserRolePermissions user = (UserRolePermissions) principals.fromRealm(this.getClass().getName()).iterator().next();
        //权限名的集合
        List<String> permissonList = new ArrayList<>();
        //角色名的集合
        List<String> roleNameList = new ArrayList<>();

        String[] temp1 = user.getPermissions().split(",");
        for (String str : temp1) {
            permissonList.add(str);
        }

        String[] temp2 = user.getRole().split(",");
        for (String str : temp2) {
            roleNameList.add(str);
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissonList);
        info.addRoles(roleNameList);
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        UserRolePermissions user = loginService.findByUsername(username);
        ByteSource salt = ByteSource.Util.bytes(user.getId());
//        return new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getName());
        return new SimpleAuthenticationInfo(user,user.getPassword(),salt,this.getClass().getName());
    }
}
