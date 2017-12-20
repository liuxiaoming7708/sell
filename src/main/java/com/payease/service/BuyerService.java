package com.payease.service;

import com.payease.dto.OrderDTO;

/**
 * 买家Service
 * @Created By liuxiaoming
 * @CreateTime 2017/11/28 上午10:57
 **/
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
