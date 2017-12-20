package com.payease.enums;

import lombok.Getter;

/**
 * 订单状态
 * Created by liuxiaoming on 2017/11/13.
 */
@Getter
public enum OrderStatusEnum implements CodeEnum{
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消")
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code,String message) {
        this.message = message;
        this.code = code;
    }

}
