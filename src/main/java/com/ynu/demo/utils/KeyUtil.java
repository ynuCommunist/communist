package com.ynu.demo.utils;

public class KeyUtil {
    /*采用时间+随机数生成唯一ID*/
    public static synchronized String getUniqueKey() {
        int number = (int) ((Math.random() * 9 + 1)*100);

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
