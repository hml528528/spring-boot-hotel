/**
 * Project Name:springboot_hotel
 * File Name:MenuController.java
 * Package Name:cn.java.controller.admin
 * Date:2020年7月8日上午7:59:31
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.java.entity.OneMenu;
import cn.java.service.MenuService;

/**
 * Description: 获取sys_limit中的所有菜单 <br/>
 * Date: 2020年7月8日 上午7:59:31 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/getAllMenus.do")
    @ResponseBody
    public List<OneMenu> getAllMenus(Long id) {
        return menuService.selectMenusByid(id);
    }
}
