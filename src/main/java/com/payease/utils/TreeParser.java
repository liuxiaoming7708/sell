package com.payease.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 解析树形数据工具类
 * @Created By liuxiaoming
 * @CreateTime 2017/12/7 下午3:41
 **/
public class TreeParser{
    /**
     * 解析树形数据
     * @param topId
     * @param entityList
     * @return
     * @Created By liuxiaoming
     * @CreateTime 2017/12/7 下午3:41
     */
    public static <E extends TreeEntity<E>> List<E> getTreeList(String topId, List<E> entityList) {
        List<E> resultList=new ArrayList<>();

        //获取顶层元素集合
        String parentId;
        if(StringUtils.isBlank(topId)){
            //全查
            for (E entity : entityList) {
                parentId=entity.getParentId();
                if(StringUtils.isBlank(parentId))
                    resultList.add(entity);
            }
        }else{
            //根据传入的ID进行向下递归
            for (E entity : entityList) {
                parentId=entity.getParentId();
                if(parentId!=null && topId.equals(parentId)){
                    resultList.add(entity);
                }
            }
        }


        //获取每个顶层元素的子数据集合
        for (E entity : resultList) {
            entity.setChildList(getSubList(entity.getId(),entityList));
        }

        return resultList;
    }

    /**
     * 获取子数据集合
     * @param id
     * @param entityList
     * @return
     * @Created By liuxiaoming
     * @CreateTime 2017/12/7 下午3:41
     */
    private  static  <E extends TreeEntity<E>>  List<E> getSubList(String id, List<E> entityList) {
        List<E> childList=new ArrayList<>();
        String parentId;

        //子集的直接子对象
        for (E entity : entityList) {
            parentId=entity.getParentId();
            if(id.equals(parentId)){
                childList.add(entity);
            }else{

            }
        }

        //子集的间接子对象
        for (E entity : childList) {
            entity.setChildList(getSubList(entity.getId(), entityList));
        }

        //递归退出条件
        if(childList.size()==0){
            return null;
        }

        return childList;
    }

}
