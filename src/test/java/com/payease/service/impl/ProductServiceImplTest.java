package com.payease.service.impl;

import com.payease.dataobject.ProductInfo;
import com.payease.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * Created by liuxiaoming on 2017/11/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void testFindOne() throws Exception {
        Assert.assertEquals("123456",productService.findOne("123456").getProductId());
    }

    @Test
    public void testFindUpAll() throws Exception {
        Assert.assertNotEquals(0,productService.findUpAll().size());
    }

    @Test
    public void testFindAll() throws Exception {
        PageRequest request = new PageRequest(0,2); //pageRequest 继承的类是实现pageAble的接口实现类
        Page<ProductInfo> ProductInfoPage = productService.findAll(request);
        //System.out.println("testFindAll: "+ProductInfoPage.getTotalElements());
        Assert.assertNotEquals(0,ProductInfoPage.getTotalElements());
    }

    @Test
    public void testSave() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好吃的虾！");
        productInfo.setProductIcon("http://baidu.com/1.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);

        Assert.assertNotNull(productService.save(productInfo));
    }
}