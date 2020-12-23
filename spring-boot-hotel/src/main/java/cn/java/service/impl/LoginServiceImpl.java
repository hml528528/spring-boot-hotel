/**
 * Project Name:springboot_hotel
 * File Name:LoginServiceImpl.java
 * Package Name:cn.java.service.impl
 * Date:2020年7月7日下午5:22:32
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.java.mapper.LoginMapper;
import cn.java.service.LoginService;
import cn.java.utils.MD5Tools;

/**
 * Description: 登录业务 <br/>
 * Date: 2020年7月7日 下午5:22:32 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    /**
     * 登录.
     * 
     * @see cn.java.service.impl.LoginService#isLogin(java.lang.String,
     *      java.lang.String)
     */
    @Override
    public Long isLogin(String username, String password) throws Exception {
        // 判断username，password是否为null
        if (username == null || password == null) {
            return null;
        }
        String regex1 = "\\w{3,12}";
        String regex2 = "\\w{6,12}";
        boolean flag1 = username.matches(regex1);
        boolean flag2 = password.matches(regex2);
        // 调用加密算法对密码进行加密
        String encey = MD5Tools.encey(password);
        if (flag1 && flag2) {

            Long id = loginMapper.login(username, encey);
            return id;
        }
        return null;

    }

}
