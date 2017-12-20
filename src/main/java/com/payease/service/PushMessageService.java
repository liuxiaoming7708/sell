package com.payease.service;

import com.payease.dto.OrderDTO;

/**
 * 推送消息
 * @Created By liuxiaoming
 * @CreateTime 2017/12/8 下午3:49
 **/
public interface PushMessageService {

    void orderStatus(OrderDTO orderDTO);
}
