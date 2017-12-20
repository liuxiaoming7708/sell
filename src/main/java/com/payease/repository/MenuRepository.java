package com.payease.repository;

import com.payease.dataobject.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by liuxiaoming on 2017/11/13.
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, String> {


    List<Menu> findById(String orderId);
}
