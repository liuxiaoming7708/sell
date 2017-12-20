package com.payease.service;

import com.payease.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * Created by liuxiaoming on 2017/11/9.
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
