/**
 * Project Name:springboot_hotel
 * File Name:LoginController.java
 * Package Name:cn.java.controller.admin
 * Date:2020年7月7日下午5:35:34
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.java.entity.OneMenu;
import cn.java.service.LoginService;
import cn.java.service.MenuService;

/**
 * Description: 登录 <br/>
 * Date: 2020年7月7日 下午5:35:34 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("/login.do")
    public String login(String username, String password, HttpSession session) throws Exception {

        Long id = loginService.isLogin(username, password);
        List<OneMenu> menusList = menuService.selectMenusByid(id);
        if (id == null) {
            session.setAttribute("error", "*账号或密码错误");
            return "redirect:/pages/admin/login.jsp";
        } else {

            session.setAttribute("username", username);
            session.setAttribute("menusList", menusList);
            return "redirect:/pages/admin/index.jsp";
        }
    }

    @RequestMapping("/logout.do")
    public String logout(HttpSession session) {
        session.removeAttribute("username");
        return "redirect:/pages/admin/login.jsp";

    }
}
