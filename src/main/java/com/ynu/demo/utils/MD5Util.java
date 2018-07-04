package com.ynu.demo.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 0:00 2018/7/4
 */
public class MD5Util {
    public static String MD5(String tempPassword,String tempSalt){
        String hashAlgorithmName = "MD5";//加密方式
        Object crdentials = tempPassword;//密码原值
        ByteSource salt = ByteSource.Util.bytes(tempSalt);//盐值
        int hashIterations = 1024;//加密1024次
        Object result = new SimpleHash(hashAlgorithmName,crdentials,salt,hashIterations);
        return result.toString();
    }
}
