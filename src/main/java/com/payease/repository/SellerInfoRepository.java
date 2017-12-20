package com.payease.repository;

import com.payease.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 卖家端
 * @Created By liuxiaoming
 * @CreateTime 2017/12/6 下午12:01
 **/
@Repository
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openid);
}
