package com.payease.repository;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.payease.VO.MenuVO;
import com.payease.dataobject.Menu;
import com.payease.utils.TreeParser1;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http://blog.csdn.net/frankcheng5143/article/details/52958486
 * @Created By liuxiaoming
 * @CreateTime 2017/12/7 下午12:51
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MenuRepositoryTest1 {

    @Autowired
    private MenuRepository repository;
    @Test
    public void findById() throws Exception {
        // 原始的数据
        List<Menu> rootMenu = repository.findAll();
        List<MenuVO> rootMenuVO = new ArrayList<>();
        // 查看结果
        for (Menu menu : rootMenu) {
            MenuVO menuVO = new MenuVO();
            BeanUtils.copyProperties(menu,menuVO);
            rootMenuVO.add(menuVO);
        }
        // 最后的结果
        List<MenuVO> menuListVO = new ArrayList<MenuVO>();
        // 先找到所有的一级菜单
        for (int i = 0; i < rootMenuVO.size(); i++) {
            // 一级菜单没有parentId
            if (StringUtils.isBlank(rootMenuVO.get(i).getParentId())) {
                menuListVO.add(rootMenuVO.get(i));
            }
        }
        // 为一级菜单设置子菜单，getChild是递归调用的
        for (MenuVO menuVO : menuListVO) {
            menuVO.setChildList(TreeParser1.getChild(menuVO.getId(), rootMenuVO));
        }
        Map<String,Object> jsonMap = new HashMap<>();
        jsonMap.put("menu", menuListVO);
        Gson gson = new Gson();
        System.out.println("gjson:" + gson.toJson(jsonMap));


        String fastJson = JSON.toJSONString(jsonMap);

        System.out.println("fastJson:"+fastJson);


    }



}