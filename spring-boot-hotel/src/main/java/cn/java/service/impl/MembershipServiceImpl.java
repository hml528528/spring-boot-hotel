/**
 * Project Name:springboot_hotel
 * File Name:MembershipServiceImpl.java
 * Package Name:cn.java.service.impl
 * Date:2020年7月15日上午11:24:59
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.java.entity.Membership;
import cn.java.mapper.MembershipMapper;
import cn.java.service.MembershipService;

/**
 * Description: 会员管理模块 <br/>
 * Date: 2020年7月15日 上午11:24:59 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
@Service
public class MembershipServiceImpl implements MembershipService {
    @Autowired
    private MembershipMapper membershipMapper;

    @Override
    public List<Map<String, Object>> selectMembershipInfo(Integer pageNum, Integer pageSize) {
        List<Map<String, Object>> membershipInfoList = membershipMapper.getMembershipInfo();
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        return membershipInfoList;
    }

    @Override
    public boolean addMembershipInfo(Membership membership) {
        // 判断用户是否已经存在
        int idcard = membershipMapper.getMembershipByidcard(membership.getIdcard());
        if (idcard >= 1) {// 用户存在
            return false;
        } else {
            // 获取当前系统时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = sdf.format(new Date());
            membership.setCreateDate(date);
            // 随机获取会员编号
            String uuid = UUID.randomUUID().toString();
            membership.setMembershipNum(uuid);
            return membershipMapper.addMembershipInfo(membership) >= 1 ? true : false;
        }

    }

    @Override
    public Map<String, Object> selectMembershipInfoByid(Long id) {

        return membershipMapper.getMembershipInfoByid(id);
    }

    @Override
    public boolean updateMembershipInfoByid(Membership membership) {
        int update = membershipMapper.updateMembershipInfoByid(membership);

        return update >= 1 ? true : false;
    }

}
