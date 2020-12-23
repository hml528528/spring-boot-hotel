/**
 * Project Name:springboot_hotel
 * File Name:LoginMapper.java
 * Package Name:cn.java.mapper
 * Date:2020年7月7日下午5:17:06
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * Description: 登录 <br/>
 * Date: 2020年7月7日 下午5:17:06 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
public interface LoginMapper {
    /**
     * 
     * Description: 登录<br/>
     *
     * @author HML
     * @param username 账号
     * @param password 密码
     * @return
     */
    @Select("SELECT id FROM sys_user WHERE username=#{arg0} AND PASSWORD=#{arg1}")
    Long login(String username, String password);
}
