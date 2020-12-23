/**
 * Project Name:springboot_hotel
 * File Name:SysUserServiceImpl.java
 * Package Name:cn.java.service.impl
 * Date:2020年7月18日上午10:21:57
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.java.entity.OneMenu;
import cn.java.mapper.SysUserMapper;
import cn.java.service.SysUserService;
import cn.java.utils.MD5Tools;

/**
 * Description: 用户管理模块 <br/>
 * Date: 2020年7月18日 上午10:21:57 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
@Service
@Transactional(readOnly = false)
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<Map<String, Object>> getSysUserInfo(Integer pageNum, Integer pageSize, String username) {
        // 后台分页
        PageHelper.startPage(pageNum, pageSize);
        return sysUserMapper.getSysUserInfo(username);
    }

    @Override
    public boolean updateSysUserStatus(Long id, String status) {
        if (status == null) {
            return false;
        }
        if (!(status.matches("[01]"))) {
            return false;
        }
        return sysUserMapper.updateSysUserStatus(id, status) >= 1 ? true : false;
    }

    @Override
    public boolean updatePassword(Long id) throws Exception {
        String pwd = "123456";
        String encry = MD5Tools.encey(pwd);
        return sysUserMapper.updatePassword(encry, id) >= 1 ? true : false;
    }

    @Override
    public List<OneMenu> getMenus() {

        return sysUserMapper.getMenus();
    }

    @Override
    public boolean insertSysUser(String username, String password, String oneIds, String twoIds) throws Exception {
        // 加密
        String encey = MD5Tools.encey(password);
        // 获取当前系统时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // 添加用户信息
        int SysUser = sysUserMapper.insertSysUser(encey, password, sdf.format(new Date()));
        if (SysUser < 1) {
            return false;
        }
        // 查询添加用户id
        Long id = sysUserMapper.selectIdByUsername(encey);
        if (id == null || id == 0) {
            return false;
        }
        // 往user_authority表中添加映射关系
        // 再添加用户与一级菜单的映射关系
        String[] oneIdsAttr = oneIds.split("\\,");
        // 取出重复一级id的值
        Set<String> oneIdSet = new HashSet<String>();
        for (String temp : oneIdsAttr) {
            oneIdSet.add(temp);
        }
        // 开始插入一级与用户的映射关系
        for (String temp : oneIdSet) {
            sysUserMapper.insertSysUserLimit(id, Long.parseLong(temp));
        }
        // 先添加用户与二级菜单的映射关系
        String[] twoIdAtr = twoIds.split("\\,");
        for (String temp : twoIdAtr) {
            sysUserMapper.insertSysUserLimit(id, Long.parseLong(temp));
        }
        return true;
    }

}
