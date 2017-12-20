package com.payease.dataobject.dao;

import com.payease.dataobject.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @Created By liuxiaoming
 * @CreateTime 2017/12/13 下午3:23
 **/
public class ProductCategoryDao {

    @Autowired
    ProductCategoryMapper mapper;

    public int insertByMap(Map<String, Object> map){
        return mapper.insertByMap(map);
    }
}
