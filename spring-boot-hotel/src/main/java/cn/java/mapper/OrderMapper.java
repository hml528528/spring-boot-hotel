/**
 * Project Name:springboot_hotel
 * File Name:OrderMapper.java
 * Package Name:cn.java.mapper
 * Date:2020年7月11日下午1:42:09
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.java.entity.Order;

/**
 * Description: 订单管理模块 <br/>
 * Date: 2020年7月11日 下午1:42:09 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
public interface OrderMapper {
    /**
     * 
     * Description:获取所有已经入住的房间号 <br/>
     *
     * @author HML
     * @return
     */
    @Select("SELECT id,room_num FROM rooms WHERE room_status=1")
    List<Map<String, Object>> getroomNum();

    /**
     * 
     * Description: 添加订单信息<br/>
     *
     * @author HML
     * @param order
     * @return
     */
    @Insert("INSERT INTO orders SET order_num=#{orderNum},total=#{total},create_date=#{checkDate},order_status=#{orderStatus},room_id=#{roomId} ")
    int addOders(Order order);

    /**
     * 
     * Description:获取所有订单 <br/>
     *
     * @author HML
     * @return
     */
    @Select("SELECT rs.id,rs.`room_num`,rc.`customer_name`,os.`order_num`,os.`total`,os.`create_date`,os.`order_status` \r\n"
            + "FROM rooms rs INNER JOIN orders os INNER JOIN room_check rc \r\n"
            + "ON rs.`id`=os.`room_id` AND rc.`room_id`=rs.`id`")
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
