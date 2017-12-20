package com.payease.repository;

import com.payease.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * Created by liuxiaoming on 2017/11/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRespositoryTest {

    @Autowired
    private ProductInfoRespository respository;

    @Test
    public void testSave() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝的粥！");
        productInfo.setProductIcon("http://baidu.com/1.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);

        Assert.assertNotNull(respository.save(productInfo));
    }


    @Test
    public void testFindByProductStatus() throws Exception {
        Assert.assertNotEquals(0,respository.findByProductStatus(0).size());
    }
}