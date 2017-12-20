package com.payease.service.impl;

import com.payease.dataobject.ProductInfo;
import com.payease.dto.CartDTO;
import com.payease.enums.ProductStatusEnum;
import com.payease.enums.ResultEnum;
import com.payease.exception.SellException;
import com.payease.repository.ProductInfoRespository;
import com.payease.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by liuxiaoming on 2017/11/10.
 */
@Service
//@CacheConfig(cacheNames = "product")
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductInfoRespository respository;

    //单一查询数据
    //使用 @Cacheable(）注解 ：
    //          先从Redis中去查
    //                有就直接显示Redis的数据
    //                没有则保存Redis 再从Redis中查数据
    @Override
    //@Cacheable(key = "123")
    public ProductInfo findOne(String productId) {
        return respository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return respository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return respository.findAll(pageable);
    }

    //修改数据
    //使用 @CachePut(） 注解则为更新Redis数据
    @Override
   // @CachePut(key = "123")
    public ProductInfo save(ProductInfo productInfo) {
        return respository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList){
            ProductInfo productInfo = respository.findOne(cartDTO.getProductId());
            if(productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);

            respository.save(productInfo);
        }

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList){
            ProductInfo productInfo = respository.findOne(cartDTO.getProductId());
            if(productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();

            if(result < 0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);

            respository.save(productInfo);
        }

    }
}
