/**
 * Project Name:springboot_hotel
 * File Name:SysUserService.java
 * Package Name:cn.java.service
 * Date:2020年7月18日上午10:20:22
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.service;

import java.util.List;
import java.util.Map;

import cn.java.entity.OneMenu;

/**
 * Description: 用户管理模块<br/>
 * Date: 2020年7月18日 上午10:20:22 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
public interface SysUserService {
    /**
     * 
     * Description:查询系统所有用户信息与分页查询 <br/>
     *
     * @author HML
     * @return
     */
    List<Map<String, Object>> getSysUserInfo(Integer pageNum, Integer pageSize, String username);

    /**
     * 
     * Description: 修改用户使用状态<br/>
     *
     * @author HML
     * @param id
     * @param status
     * @return
     */
    boolean updateSysUserStatus(Long id, String status);

    /**
     * 
     * Description:重置密码 <br/>
     *
     * @author HML
     * @param id
     * @return
     */
    boolean updatePassword(Long id) throws Exception;

    /**
     * 
     * Description:获取所有菜单信息 <br/>
     *
     * @author HML
     * @return
     */
    List<OneMenu> getMenus();

    /**
     * 
     * Description:添加系统用户信息 <br/>
     *
     * @author HML
     * @param username
     * @param password
     * @param createDate
     * @return
     */
    boolean insertSysUser(String username, String password, String oneIds, String twoIds) throws Exception;

}
