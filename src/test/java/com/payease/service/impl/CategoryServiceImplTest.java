package com.payease.service.impl;

import com.payease.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * Created by liuxiaoming on 2017/11/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void testFindOne() throws Exception {

        Assert.assertEquals(new Integer(1),categoryService.findOne(1).getCategoryId());
    }

    @Test
    public void testFindAll() throws Exception {
        Assert.assertNotEquals(0,categoryService.findAll().size());
    }

    @Test
    public void testFindByCategoryTypeIn() throws Exception {
        Assert.assertNotEquals(0,categoryService.findByCategoryTypeIn(Arrays.asList(1,2,3,4)).size());
    }

    @Test
    public void testSave() throws Exception {
        ProductCategory productCategory = new ProductCategory("男生专享",10);

        Assert.assertNotNull(categoryService.save(productCategory));
    }

    @Test
    public void save() throws Exception {

    }
}