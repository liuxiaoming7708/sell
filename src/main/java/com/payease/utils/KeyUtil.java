package com.payease.utils;

import java.util.Random;

/**
 * liuxiaoming
 * 2017-11-20
 */
public class KeyUtil {

    /**
     * 随机数 位数自定
     * @return
     */
    public static String RandomNumber(Integer num){

        int a[] = new int[num];
        String ram ="";
        for(int i=0;i<a.length;i++ ) {
            a[i] = (int)(10*(Math.random()));
            System.out.print(a[i]);
            ram += a[i];
        }
        return ram;
    }
    /**
     * 生成唯一主键
     * 格式： 时间+随机数（6位随机数）
     *  synchronized 多线程关键字
     */
    public static synchronized String getUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000; //六位随机数

        return  System.currentTimeMillis() + String.valueOf(number);
    }
}
