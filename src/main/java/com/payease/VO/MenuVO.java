package com.payease.VO;

import com.payease.utils.TreeEntity;
import lombok.Data;

import java.util.List;

/**
 * @Created By liuxiaoming
 * @CreateTime 2017/12/7 下午12:58
 **/
@Data
public class MenuVO implements TreeEntity<MenuVO> {
    // 菜单id
    public String id;
    // 菜单名称
    public String name;
    // 父菜单id
    public String parentId;
    // 菜单url
    public String url;
    // 菜单图标
    public String icon;
    // 菜单顺序
    public int order;
    // 子菜单
    public List<MenuVO> childList;


}
