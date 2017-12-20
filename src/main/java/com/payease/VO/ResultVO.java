package com.payease.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回最外层对象
 * Created by liuxiaoming on 2017/11/11.
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO<T> implements Serializable{

    private static final long serialVersionUID = 816318696842351963L;

    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String msg;

    /** 具体内容 */
    private T data;
}
