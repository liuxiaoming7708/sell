package com.payease.exception;

import com.payease.enums.ResultEnum;
import lombok.Getter;

/**
 * liuxiaoming
 * 2017-11-20
 */
@Getter
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum){
            super(resultEnum.getMessage());

            this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message){
        super(message);
        this.code = code;
    }


}
