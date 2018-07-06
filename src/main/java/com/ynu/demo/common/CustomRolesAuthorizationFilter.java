package com.ynu.demo.common;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ynu.demo.Enum.ResultEnum;
import com.ynu.demo.exception.MyException;
import com.ynu.demo.result.ReturnResult;
import com.ynu.demo.utils.ReturnResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.io.PrintWriter;

// AuthorizationFilter抽象类事项了javax.servlet.Filter接口，它是个过滤器。
public class CustomRolesAuthorizationFilter extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest req, ServletResponse resp, Object mappedValue) {
        Subject subject = SecurityUtils.getSubject();
        String[] rolesArray = (String[]) mappedValue;


        if (rolesArray == null || rolesArray.length == 0) { //没有角色限制，有权限访问
            return true;
        }
        for (int i = 0; i < rolesArray.length; i++) {
            if (subject.hasRole(rolesArray[i])) { //若当前用户是rolesArray中的任何一个，则有权限访问
                return true;
            }
        }

        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if (req.getMethod().equals(RequestMethod.OPTIONS.name())) {
            resp.setStatus(HttpStatus.OK.value());
            return true;
        }
//            //前端Ajax请求时requestHeader里面带一些参数，用于判断是否是前端的请求
//            String ajaxHeader = req.getHeader(ShiroCon);
        //前端Ajax请求，则不会重定向
        resp.setHeader("Access-Control-Allow-Origin", req.getHeader("Origin"));
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setContentType("application/json; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
            out = resp.getWriter();
        } catch (IOException e) {
            throw new MyException(ResultEnum.AUTH_ERROR);
        }
        JSONObject result = new JSONObject();

        Subject subject =SecurityUtils.getSubject();
        try{
            if (subject.getPrincipal() == null) {
                result.put("msg", "未登录，请重新登陆");
                result.put("code", ResultEnum.NOT_LOGIN.getCode());
            } else {
                result.put("msg", "权限不足");
                result.put("code", ResultEnum.AUTHORITY_ERROR.getCode());
            }
        }catch (JSONException e){
            throw new MyException(ResultEnum.JSON_ERROR);
        }

        out.println(result);
        out.flush();
        out.close();
        return false;

    }

    /**
     * 判断ajax请求
     *
     * @param request
     * @return
     */
    private boolean isAjaxRequest(ServletRequest request) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        return "XMLHttpRequest".equalsIgnoreCase(httpServletRequest.getHeader("X-Requested-With"));
    }
}