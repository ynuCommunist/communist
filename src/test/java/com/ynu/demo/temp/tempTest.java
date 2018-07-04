package com.ynu.demo.temp;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 15:59 2018/7/3
 */

public class tempTest {

    @Test
    public void temp(){
        String hashAlgorithmName = "MD5";//加密方式
        Object crdentials = "1";//密码原值
        ByteSource salt = ByteSource.Util.bytes("2");//盐值
        int hashIterations = 1024;//加密1024次
        Object result = new SimpleHash(hashAlgorithmName,crdentials,salt,hashIterations);
//        SimpleHash temp = new SimpleHash();
        System.out.println(result);
    }
}