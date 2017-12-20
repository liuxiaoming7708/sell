package com.payease.repository;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.payease.VO.MenuVO;
import com.payease.dataobject.Menu;
import com.payease.utils.TreeParser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created By liuxiaoming
 * @CreateTime 2017/12/7 下午12:51
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MenuRepositoryTest {

    @Autowired
    private MenuRepository repository;
    @Test
    public void findById() throws Exception {
        // 原始的数据
        List<Menu> rootMenu = repository.findAll();
        // 查看结果
        List<MenuVO> rootMenuVO = new ArrayList<>();
        for (Menu menu : rootMenu) {
            MenuVO menuVO = new MenuVO();
            BeanUtils.copyProperties(menu,menuVO);
            rootMenuVO.add(menuVO);
        }

        List<MenuVO> child = TreeParser.getTreeList("",rootMenuVO);

        List<MenuVO>  menus = TreeParser.getTreeList("2",rootMenuVO);
        System.out.println(menus);

        Gson gson = new Gson();
        String gJson = gson.toJson(menus);
        System.out.println("gjson:"+gJson);

        String fastJson = JSON.toJSONString(child);

        System.out.println("fastJson:"+fastJson);


    }



}