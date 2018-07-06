package com.ynu.demo.config;

import com.ynu.demo.common.CustomRolesAuthorizationFilter;
import com.ynu.demo.common.ShiroFormAuthenticationFilter;
import com.ynu.demo.realm.MyRealm;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 10:46 2018/6/30
 */
@Configuration
@Slf4j
public class ShiroConfiguration {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") SecurityManager manager){
        ShiroFilterFactoryBean bean =new  ShiroFilterFactoryBean();
        bean.setSecurityManager(manager);

        // 添加自定义过滤器
        Map<String, Filter> filtersMap = new LinkedHashMap<String, Filter>();
        filtersMap.put("myAccessControlFilter", new CustomRolesAuthorizationFilter());
        filtersMap.put("sfaun", new ShiroFormAuthenticationFilter());
        bean.setFilters(filtersMap);

        bean.setLoginUrl("/loginInterceptor");
        bean.setSuccessUrl("/index");
        bean.setUnauthorizedUrl("/unauthorized");

        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
//        filterChainDefinitionMap.put("/index","sfaun");
        filterChainDefinitionMap.put("/login","anon");
////        filterChainDefinitionMap.put("/admin/**","myAccessControlFilter[admin]");
////        filterChainDefinitionMap.put("/user/**","myAccessControlFilter[user,admin]");
        filterChainDefinitionMap.put("/admin/**","myAccessControlFilter[admin]");
        filterChainDefinitionMap.put("/user/**","myAccessControlFilter[user,admin]");

//        filterChainDefinitionMap.put("/admin/find/*","perms[find]");
//        filterChainDefinitionMap.put("/admin/add/*","perms[add]");
//        filterChainDefinitionMap.put("/admin/delete/*","perms[delete]");
//        filterChainDefinitionMap.put("/admin/update/*","perms[update]");
//        filterChainDefinitionMap.put("/user/find/*","perms[find]");
//        filterChainDefinitionMap.put("/**","authc");
        filterChainDefinitionMap.put("/druid/**","anon");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return bean;
    }

    @Bean("securityManager")
    public SecurityManager securityManager(@Qualifier("myRealm") MyRealm myRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myRealm);
        manager.setRememberMeManager(rememberMeManager());
        return manager;
    }

//    @Bean("myRealm")
//    public MyRealm myRealm(@Qualifier("CredentialMatcher") CredentialMatcher matcher ){
//        MyRealm myRealm = new MyRealm();
//        myRealm.setCacheManager(new MemoryConstrainedCacheManager());
//        myRealm.setCredentialsMatcher(matcher);
//        return myRealm;
//    }

//    @Bean("CredentialMatcher")
//    public CredentialMatcher credentialMatcher(){
//        return new CredentialMatcher();
//    }

    @Bean("myRealm")
    public MyRealm myRealm(@Qualifier("hashedCredentialsMatcher") HashedCredentialsMatcher matcher ){
        MyRealm myRealm = new MyRealm();
        myRealm.setCacheManager(new MemoryConstrainedCacheManager());
        myRealm.setCredentialsMatcher(matcher);
        return myRealm;
    }

    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //指定加密方式为MD5
        credentialsMatcher.setHashAlgorithmName("MD5");
        //加密次数
        credentialsMatcher.setHashIterations(1024);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }


    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

    public SimpleCookie rememberMeCookie(){
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(3*300000000);
        return simpleCookie;
    }

    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("3AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }
}
