/**
 * Project Name:springboot_hotel
 * File Name:MenuServiceImpl.java
 * Package Name:cn.java.service.impl
 * Date:2020年7月8日上午8:02:31
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cn.java.entity.OneMenu;
import cn.java.mapper.MenuMapper;
import cn.java.service.MenuService;

@Service
@CacheConfig(cacheNames = { "MenuServiceImplCache" })
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    /**
     * 
     * 获取sys_limit中的所有菜单
     * 
     * @see cn.java.service.LoginService#selectMenus()
     */
    @Cacheable(key = "'selectMenusByid'")
    @Override
    public List<OneMenu> selectMenusByid(Long id) {
        return menuMapper.getMenusByid(id);
    }
}
