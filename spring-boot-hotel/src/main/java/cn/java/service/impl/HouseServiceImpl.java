/**
 * Project Name:springboot_hotel
 * File Name:HouseServiceImpl.java
 * Package Name:cn.java.service.impl
 * Date:2020年7月16日下午8:54:22
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.java.mapper.HouseMapper;
import cn.java.service.HouseService;

/**
 * Description: <br/>
 * Date: 2020年7月16日 下午8:54:22 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
@Service
@Transactional(readOnly = false)
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;

    @Transactional(readOnly = true)
    @Override
    public List<Map<String, Object>> selectHouseInfo(Integer pageNum, Integer pageSize) {
        // 利用 pageHelper分页
        PageHelper.startPage(pageNum, pageSize);
        return houseMapper.getHouseInfo();
    }

    @Override
    public List<Map<String, Object>> selectHouseType() {

        return houseMapper.getHouseType();
    }

    @Override
    public List<Map<String, Object>> selectHouseInfoByCondition(Integer pageNum, Integer pageSize, String type,
            String keyword) {
        // 后台分页
        PageHelper.startPage(pageNum, pageSize);
        return houseMapper.getHouseInfoByCondition(type, keyword);
    }

    @Override
    public boolean selectRoomNums(String roomNum) {

        if (roomNum == null || roomNum == "0") {
            return false;
        }
        int roomNums = houseMapper.getRoomNums(roomNum);
        if (roomNums >= 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addHouseInfo(String roomNum, String roomStatus, Long roomTypeId) {
        if (roomNum == null || roomStatus == null || roomTypeId == null || (roomNum != null && roomNum.trim() == "")) {
            return false;
        }
        if (!(roomStatus.matches("[012]"))) {
            return false;
        }

        return houseMapper.addHouseInfo(roomNum, roomStatus, roomTypeId) >= 1 ? true : false;
    }

    @Override
    public List<Map<String, Object>> getHouseTypeInfo(Integer pageNum, Integer pageSize) {

        // 后台分页
        PageHelper.startPage(pageNum, pageSize);
        return houseMapper.getHouseTypeInfo();

    }

}
