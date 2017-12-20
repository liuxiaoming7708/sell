package com.payease.service.impl;

import com.payease.dataobject.SellerInfo;
import com.payease.repository.SellerInfoRepository;
import com.payease.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Created By liuxiaoming
 * @CreateTime 2017/12/6 下午2:32
 **/
@Service
public class SellerServiceImpl implements SellerService{

    @Autowired
    private SellerInfoRepository repository;
    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
