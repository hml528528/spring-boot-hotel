/**
 * Project Name:springboot_hotel
 * File Name:HouseMapper.java
 * Package Name:cn.java.mapper
 * Date:2020年7月16日下午8:51:26
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.mapper;
/**
 * Description:	房间管理模块   <br/>
 * Date:     2020年7月16日 下午8:51:26 <br/>
 * @author   HML
 * @version  
 * @see 	 
 */

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface HouseMapper {
    /**
     * 
     * Description:查询所有客房信息 <br/>
     *
     * @author HML
     * @return
     */
    @Select("SELECT rs.`id`,rs.`room_num`,rt.`room_type`,rt.`room_price`,rs.`room_status` FROM room_type rt INNER JOIN rooms rs ON rt.`id`=rs.`room_type_id`")
    List<Map<String, Object>> getHouseInfo();

    /**
     * 
     * Description:查询客房类型 <br/>
     *
     * @author HML
     * @return
     */
    @Select("SELECT * FROM room_type")
    List<Map<String, Object>> getHouseType();

    /**
     * 
     * Description:根据条件查询房间信息 <br/>
     *
     * @author HML
     * @return
     */
    List<Map<String, Object>> getHouseInfoByCondition(String type, String keyword);

    /**
     * 
     * Description: 判断房间号是否存在<br/>
     *
     * @author HML
     * @return
     */
    @Select("SELECT COUNT(*) AS num FROM rooms WHERE room_num=#{arg0}")
    int getRoomNums(String roomNum);

    /**
     * 
     * Description:添加房间信息 <br/>
     *
     * @author HML
     * @return
     */
    @Insert("INSERT INTO `rooms` SET room_num=#{arg0},room_status=#{arg1},room_type_id=#{arg2}")
    int addHouseInfo(String roomNum, String roomStatus, Long roomTypeId);

    /**
     * 
     * Description:查询客房类型 <br/>
     *
     * @author HML
     * @return
     */
    @Select("SELECT * FROM room_type")
    List<Map<String, Object>> getHouseTypeInfo();
}
