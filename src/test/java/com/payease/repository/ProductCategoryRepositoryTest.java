package com.payease.repository;

import com.payease.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * Created by liuxiaoming on 2017/11/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        System.out.println(repository.findOne(1).toString());
    }

    @Test
    @Transactional  //事物注解 ：在service中出现异常情况，数据回滚  在测试类中数据完全回滚
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("男生最爱",5);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
        //Assert.assertNotEquals(null,result);
        //repository.saveAndFlush(productCategory);

//        ArrayList<String> objects = new ArrayList<>();
//        objects.add("1");
//        objects.add("2");
//        for (String s: objects){
//            System.out.println(s);
//        }


    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }

}