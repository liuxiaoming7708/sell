package com.payease.service.impl;

import com.payease.dto.OrderDTO;
import com.payease.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Created By liuxiaoming
 * @CreateTime 2017/12/11 上午9:48
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {

    @Autowired
    private PushMessageServiceImpl pushMessageServiceImpl;
    @Autowired
    private OrderService orderService;

    @Test
    public void orderStatus() throws Exception {
        OrderDTO orderDTO = orderService.findOne("1511749057819887679");
        pushMessageServiceImpl.orderStatus(orderDTO);
    }

}