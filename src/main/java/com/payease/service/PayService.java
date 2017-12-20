package com.payease.service;

import com.payease.dto.OrderDTO;

/**
 * 支付
 * @Created By liuxiaoming
 * @CreateTime 2017/11/29 下午1:59
 **/
public interface PayService {

    void create(OrderDTO orderDTO);
}
