/**
 * Project Name:springboot_hotel
 * File Name:SysUserMapper.java
 * Package Name:cn.java.mapper
 * Date:2020年7月18日上午10:11:11
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.mapper;
/**
 * Description:	   <br/>
 * Date:     2020年7月18日 上午10:11:11 <br/>
 * @author   HML
 * @version  
 * @see 	 
 */

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.java.entity.OneMenu;

public interface SysUserMapper {
    /**
     * 
     * Description:查询系统所有用户信息与分页查询 <br/>
     *
     * @author HML
     * @return
     */
    List<Map<String, Object>> getSysUserInfo(@Param(value = "username") String username);

    /**
     * 
     * Description: 修改用户使用状态<br/>
     *
     * @author HML
     * @param id
     * @param status
     * @return
     */
    @Update("UPDATE sys_user SET `status`=#{arg1} WHERE id=#{arg0} ")
    int updateSysUserStatus(Long id, String status);

    /**
     * 
     * Description:重置密码 <br/>
     *
     * @author HML
     * @param id
     * @return
     */
    @Update("UPDATE sys_user SET PASSWORD=#{arg0} WHERE id=#{arg1}")
    int updatePassword(String password, Long id);

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
    @Insert("INSERT INTO sys_user VALUES(NULL,#{arg0},#{arg1},1,0,#{arg2})")
    int insertSysUser(String username, String password, String createDate);

    /**
     * 
     * Description: 查询添加用户的id<br/>
     *
     * @author HML
     * @return
     */
    @Select("SELECT id FROM sys_user WHERE username=#{arg0}")
    Long selectIdByUsername(String username);

    /**
     * 
     * Description:添加系统权限 <br/>
     *
     * @author HML
     * @param oneIds
     * @param twoIds
     * @return
     */
    @Insert("INSERT INTO user_limit VALUES(NULL,#{arg0},#{arg1})")
    int insertSysUserLimit(Long id, Long twoIds);

}
