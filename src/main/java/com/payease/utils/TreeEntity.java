package com.payease.utils;

import java.util.List;

/**
 * 树形数据实体接口
 * @param <E>
 * @Created By liuxiaoming
 * @CreateTime 2017/12/7 下午3:39
 **/
public interface TreeEntity<E> {
    // 菜单id
    public String getId();
    // 菜单名称
    public String getName();
    // 父菜单id
    public String getParentId();
    // 菜单url
    public String getUrl();
    // 菜单图标
    public String getIcon();
    // 菜单顺序
    public int getOrder();


    public void setChildList(List<E> childList);

}
