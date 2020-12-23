/**
 * Project Name:springboot_hotel
 * File Name:LoginService.java
 * Package Name:cn.java.service.impl
 * Date:2020年7月7日下午5:28:35
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.service;

public interface LoginService {
    /**
     * 
     * Description: 登录<br/>
     *
     * @author HML
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    Long isLogin(String username, String password) throws Exception;

}
