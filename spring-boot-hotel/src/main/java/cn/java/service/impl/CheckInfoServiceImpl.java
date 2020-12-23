/**
 * Project Name:springboot_hotel
 * File Name:CheckInfoServiceImpl.java
 * Package Name:cn.java.service.impl
 * Date:2020年7月8日下午7:52:50
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.java.entity.CheckInfo;
import cn.java.entity.CheckOut;
import cn.java.mapper.CheckInfoMapper;
import cn.java.service.CheckInfoService;

/**
 * Description: 入住信息管理模块 <br/>
 * Date: 2020年7月8日 下午7:52:50 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
@Service
@Transactional(readOnly = false)
public class CheckInfoServiceImpl implements CheckInfoService {
    @Autowired
    private CheckInfoMapper checkInfoMapper;

    @Override
    public List<Map<String, Object>> selectCheckInfos(Integer pageNum, Integer pageSize) {
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> checkInfos = checkInfoMapper.getCheckInfos();
        return checkInfos;
    }

    @Override
    public List<Map<String, Object>> selectCheckInfosBycondition(String type, String keyword) {
        List<Map<String, Object>> checklist = checkInfoMapper.getCheckInfosBycondition(type, keyword);
        return checklist;
    }

    @Override
    public boolean deleteCheckInfoByid(Long id) {
        int delete = checkInfoMapper.deleteCheckInfoByid(id);

        return delete >= 1 ? true : false;
    }

    @Override
    public boolean batchDelete(String idStrr) {
        String id = idStrr.substring(0, idStrr.length() - 1);
        int batchDelete = checkInfoMapper.batchDelete(id);
        return batchDelete >= 1 ? true : false;
    }

    @Override
    public List<Map<String, Object>> selectRoomNums() {

        return checkInfoMapper.getRoomNums();
    }

    @Override
    public boolean saveCheckInfo(CheckInfo checkInfo) {
        // 根据房间号查询id
        Long id = checkInfoMapper.getIdByroomNum(checkInfo.getRoomNum());
        // 添加入住信息
        checkInfo.setId(id);
        int info = checkInfoMapper.insertCheckInfo(checkInfo);
        if (info >= 1) {
            // 更新房间状态
            checkInfoMapper.updateCheckInfostatusByid(checkInfo.getId());
            return true;
        }

        return false;
    }

    @Override
    public List<Map<String, Object>> selectCheckRoomNum() {

        return checkInfoMapper.getCheckRoomNum();
    }

    @Override
    public Map<String, Object> detailCheckInfo(Long roomId) {
        Float otherConsume = checkInfoMapper.getotherConsume(roomId);
        Map<String, Object> detailCheckInfoMap = checkInfoMapper.detailCheckInfo(roomId);

        detailCheckInfoMap.put("otherConsume", otherConsume);
        return detailCheckInfoMap;
    }

    @Override
    public Float getroompriceByroomNum(Long id) {

        return checkInfoMapper.getroompriceByroomid(id);
    }

    @Override
    public Float checkout(CheckOut checkOut) throws Exception {
        // 判断顾客是否是会员
        Float isvip = checkInfoMapper.getdiscountByroomid(checkOut.getRoomId());
        // 计算入住时间差
        // 入住时间
        String checkDate = checkOut.getCheckDate();
        // 退房时间
        String checkoutDate = checkOut.getCheckoutDate();// 2020-07-16 16:08:11
        // 时间格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse(checkDate);
        Date date2 = sdf.parse(checkoutDate);
        int days = (int) ((date2.getTime() - date1.getTime()) / (24 * 3600 * 1000));
        String checkoutDate2 = checkoutDate.split("\\ ")[1].split("\\:")[0];
        int date3 = Integer.parseInt(checkoutDate2);
        // 判断时间[16]:08:11是否大于12
        if (date3 >= 12) {
            days++;
        }
        // 修改房间状态
        checkInfoMapper.updateroomStatusByrooId(checkOut.getRoomId());
        // 修改退房状态
        checkInfoMapper.upadtecheckoutStatusByroomId(checkOut.getRoomId());

        // 计算价格
        if (isvip == null || isvip == 0) {// 不是会员
            return (days * (checkOut.getPrice()) + checkOut.getOtherConsume() - checkOut.getDeposit());
        }
        // 是会员
        return (days * (checkOut.getPrice()) * isvip + checkOut.getOtherConsume() - checkOut.getDeposit());

    }

}
