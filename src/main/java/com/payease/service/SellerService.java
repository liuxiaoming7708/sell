package com.payease.service;

import com.payease.dataobject.SellerInfo;

/**
 * 卖家端
 * @Created By liuxiaoming
 * @CreateTime 2017/12/6 下午2:29
 **/
public interface SellerService {

    /**
     * 通过openid查询卖家信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
