/**
 * Project Name:springboot_hotel
 * File Name:SysUserController.java
 * Package Name:cn.java.controller.admin
 * Date:2020年7月18日上午9:58:47
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.java.entity.OneMenu;
import cn.java.service.SysUserService;

/**
 * Description: 用户管理模块 <br/>
 * Date: 2020年7月18日 上午9:58:47 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
@Controller
public class SysUserController {
    /**
     * 
     * Description:查询系统所有用户信息与分页查询 <br/>
     *
     * @author HML
     * @param username
     * @return
     */
    @Autowired
    private SysUserService sysUserService;

    /**
     * 
     * Description:获取用户信息 <br/>
     *
     * @author HML
     * @param pageNum
     * @param pageSize
     * @param username
     * @param model
     * @return
     */
    @RequestMapping("/getSysUserInfo.do")
    public String getSysUserInfo(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize, String username, Model model) {
        // 调用业务方法
        List<Map<String, Object>> userInfoList = sysUserService.getSysUserInfo(pageNum, pageSize, username);
        // 前台分页
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(userInfoList);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/user/SysUser.jsp";
    }

    /**
     * 
     * Description:修改 系统用户状态<br/>
     *
     * @author HML
     * @param id
     * @param status
     * @return
     */

    @RequestMapping("/updateSysUserStatus.do")
    @ResponseBody
    public boolean updateSysUserStatus(Long id, String status) {
        boolean flag = sysUserService.updateSysUserStatus(id, status);
        return flag;
    }

    /**
     * 
     * Description:重置密码 <br/>
     *
     * @author HML
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/updatePassword.do")
    @ResponseBody
    public boolean updatePassword(Long id, HttpSession session) throws Exception {
        // 判断是否是超级管理员
        boolean flag = sysUserService.updatePassword(id);
        if (flag) {
            session.invalidate();
        }
        return flag;
    }

    /**
     * 
     * Description:查询所有菜单并跳转到添加系统用户页面 <br/>
     *
     * @author HML
     * @param model
     * @return
     */
    @RequestMapping("/addUserLimit.do")
    public String addUserLimit(Model model) {
        List<OneMenu> menusList = sysUserService.getMenus();
        System.out.println(menusList);
        model.addAttribute("menusList", menusList);
        return "admin/user/addSysUserLimit.jsp";
    }

    /**
     * 
     * Description:添加用户权限 <br/>
     *
     * @author HML
     * @return
     * @throws Exception
     */
    @RequestMapping("/addSysUserLimit.do")
    public @ResponseBody boolean addSysUserLimit(String username, String password, String oneIds, String twoIds)
            throws Exception {
        System.out.println(username + "_------" + password + "------" + oneIds + "--------" + twoIds);
        // 添加用户信息
        boolean flag = sysUserService.insertSysUser(username, password, oneIds, twoIds);
        if (flag) {
            return true;
        }
        return false;
    }

}
