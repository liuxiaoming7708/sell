package com.payease.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by liuyxiaoming
 * 2017-11-13
 */
@Entity
@Data
public class OrderDetail {

    @Id
    public String detailId;

    /** 订单id. */
    public String orderId;

    /** 商品id. */
    public String productId;

    /** 商品名称. */
    public String productName;

    /** 商品单价. */
    public BigDecimal productPrice;

    /** 商品数量. */
    public Integer productQuantity;

    /** 商品小图. */
    public String productIcon;
}
