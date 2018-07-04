package com.ynu.demo.temp;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 15:54 2018/7/3
 */
public class temp {
    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";//加密方式
        Object crdentials = "1";//密码原值
        Object salt = 1;//盐值
        int hashIterations = 1024;//加密1024次
        Object result = new SimpleHash(hashAlgorithmName,crdentials,salt,hashIterations);
        System.out.println(result);
    }

}
