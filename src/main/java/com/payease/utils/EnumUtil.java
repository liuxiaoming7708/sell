package com.payease.utils;

import com.payease.enums.CodeEnum;

/**
 * @Created By liuxiaoming
 * @CreateTime 2017/12/1 下午4:16
 **/
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for (T each : enumClass.getEnumConstants()){
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
