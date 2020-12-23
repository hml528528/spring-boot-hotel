/**
 * Project Name:springboot_hotel
 * File Name:OrderServiceImpl.java
 * Package Name:cn.java.service.impl
 * Date:2020年7月11日下午1:47:48
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
import org.springframework.transaction.annotation.Transactional;

import cn.java.entity.Order;
import cn.java.mapper.OrderMapper;
import cn.java.service.OrderService;

@Service
@Transactional(readOnly = false)
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Map<String, Object>> selectroomNum() {

        return orderMapper.getroomNum();
    }

    @Override
    public boolean addOders(Order order) {
        // 订单编号
        String uuid = UUID.randomUUID().toString();
        // 获取创建时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String dt = sdf.format(new Date());
        order.setOrderNum(uuid);
        order.setCheckDate(dt);
        return orderMapper.addOders(order) >= 1 ? true : false;
    }

    @Override
    public List<Map<String, Object>> getOrders() {

        return orderMapper.getOrders();
    }

    @Override
    public List<Map<String, Object>> getOrdersBycondition(String type, String keyword) {

        return orderMapper.getOrdersBycondition(type, keyword);
    }

}
