package com.ynu.demo.utils;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 21:38 2018/7/3
 */
public class TranferUtils {

    public static String ArrayToString(String[] arrays){
        String result = arrays[0];
        for (int i = 1; i < arrays.length; i++) {
            result = result + "," + arrays[i];
        }
        return result;
    }

    public static String[] ArrayToString(String str){
        String[] result = str.split(",");
        return result;
    }
}
