/**
 * Project Name:springboot_hotel
 * File Name:OrderService.java
 * Package Name:cn.java.service
 * Date:2020年7月11日下午1:44:51
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.service;

import java.util.List;
import java.util.Map;

import cn.java.entity.Order;

/**
 * Description:订单模块 <br/>
 * Date: 2020年7月11日 下午1:44:51 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
public interface OrderService {
    /**
     * 
     * Description:获取所有已入住的房间编号 <br/>
     *
     * @author HML
     * @return
     */
    List<Map<String, Object>> selectroomNum();

    /**
     * 
     * Description:添加订单信息 <br/>
     *
     * @author HML
     * @param order
     * @return
     */
    boolean addOders(Order order);

    /**
     * 
     * Description:获取所有订单 <br/>
     *
     * @author HML
     * @return
     */
    List<Map<String, Object>> getOrders();

    /**
     * 
     * Description:通过条件查询订单信息 <br/>
     *
     * @author HML
     * @return
     */
    List<Map<String, Object>> getOrdersBycondition(String type, String keyword);

}
