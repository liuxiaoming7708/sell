package com.payease.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 菜单循环递归类
 * @Created By liuxiaoming
 * @CreateTime 2017/12/7 下午12:46
 **/
@Entity
@Data
public class Menu {
    // 菜单id
    @Id
    private String id;
    // 菜单名称
    private String name;
    // 父菜单id
    private String parentId;
    // 菜单url
    private String url;
    // 菜单图标
    private String icon;
    // 菜单顺序
    private int order;

    // ... 省去getter和setter方法以及toString方法
}
