/**
 * Project Name:springboot_hotel
 * File Name:MenuService.java
 * Package Name:cn.java.service
 * Date:2020年7月8日上午8:01:22
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.service;

import java.util.List;

import cn.java.entity.OneMenu;

public interface MenuService {
    /**
     * 
     * Description: 获取sys_limit中的所有菜单<br/>
     *
     * @author HML
     * @return
     */
    List<OneMenu> selectMenusByid(Long id);

}
