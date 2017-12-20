package com.payease.dataobject.mapper;


import com.payease.dataobject.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @Created By liuxiaoming
 * @CreateTime 2017/12/12 下午6:13
 **/

public interface ProductCategoryMapper {

    /**
     * 通过参数为map保存
     * @param map
     * @return
     */
    @Insert("insert into product_category(category_name, category_type) values (#{category_name , jdbcType=VARCHAR}, #{category_type, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    /**
     * 通过参数为对象保存
     * @param productCategory
     * @return
     */
    @Insert("insert into product_category(category_name, category_type) values (#{categoryName , jdbcType=VARCHAR}, #{categoryType, jdbcType=INTEGER})")
    int insertByObject(ProductCategory productCategory);


    /**
     * 查单一数据
     * 通过categoryType查询product_category表 @Result注解设置返回值
     * @param categoryType
     * @return
     */
    @Select("select * from product_category where category_type = #{categoryType}")
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_type", property = "categoryType")
    })
    ProductCategory findByCategoryType(Integer categoryType);

    /**
     * 查集合
     * 通过categoryName查询product_category表 @Result注解设置返回值
     * @param categoryName
     * @return
     */
    @Select("select * from product_category where category_name = #{categoryName}")
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_type", property = "categoryType")
    })
    List<ProductCategory> findByCategoryName(String categoryName);

    /**
     * 根据某个字段更新
     * 通过查询category_type 来修改 category_name
     * @param categoryName
     * @param categoryType
     * @return
     */
    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByCategoryType(@Param("categoryName") String categoryName,
                             @Param("categoryType") Integer categoryType);

    /**
     * 根据对象更新
     * 通过查询category_type 来修改 category_name
     * @param productCategory
     * @return
     */
    @Update("update product_category set category_name = #{categorName} where category_type = #{categoryType}")
    int updateByObject(ProductCategory productCategory);

    /**
     * 根据某个字段来删除数据
     * 通过category_type 来删除数据
     * @param categoryType
     * @return
     */
    @Delete("delete from product_category where category_type = #{categoryType}")
    int deleteByCategoryType(Integer categoryType);

    /**
     * mybatis xml的使用样例
     * 通过categoryType 查询数据
     * @param categoryType
     * @return
     */
    ProductCategory selectByCategoryType(Integer categoryType);
}
