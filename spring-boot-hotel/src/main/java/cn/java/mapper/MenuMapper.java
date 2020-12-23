/**
 * Project Name:springboot_hotel
 * File Name:MenuMapper.java
 * Package Name:cn.java.mapper
 * Date:2020年7月8日上午7:36:25
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.mapper;

import java.util.List;

import cn.java.entity.OneMenu;

/**
 * Description:获取sys_limit中的所有菜单 <br/>
 * Date: 2020年7月8日 上午7:36:25 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
public interface MenuMapper {

    List<OneMenu> getMenusByid(Long id);
}
