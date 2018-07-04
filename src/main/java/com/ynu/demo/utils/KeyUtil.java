package com.ynu.demo.utils;

import java.util.Random;

public class KeyUtil {

    /**
     *
     *
     * @return
     */
    /**
     * @desc 采用时间+随机数生成唯一的主键
     * @parameters null
     * @return  唯一ID
     **/
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
