/**
 * Project Name:springboot_hotel
 * File Name:HouseService.java
 * Package Name:cn.java.service
 * Date:2020年7月16日下午8:53:32
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

/**
 * Description: 客房管理模块 <br/>
 * Date: 2020年7月16日 下午8:53:32 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
public interface HouseService {
    /**
     * 
     * Description:查询所有客房信息 <br/>
     *
     * @author HML
     * @return
     */
    List<Map<String, Object>> selectHouseInfo(Integer pageNum, Integer pageSize);

    /**
     * 
     * Description:查询客房类型 <br/>
     *
     * @author HML
     * @return
     */
    List<Map<String, Object>> selectHouseType();

    /**
     * 
     * Description:根据条件查询房间信息 <br/>
     *
     * @author HML
     * @return
     */
    List<Map<String, Object>> selectHouseInfoByCondition(Integer pageNum, Integer pageSize, String type,
            String keyword);

    /**
     * 
     * Description: 判断房间号是否存在<br/>
     *
     * @author HML
     * @return
     */
    boolean selectRoomNums(String roomNum);

    /**
     * 
     * Description:添加房间信息 <br/>
     *
     * @author HML
     * @return
     */
    boolean addHouseInfo(String roomNum, String roomStatus, Long roomTypeId);

    /**
     * 
     * Description:查询客房类型 <br/>
     *
     * @author HML
     * @return
     */
    @Select("SELECT * FROM room_type")
    List<Map<String, Object>> getHouseTypeInfo(Integer pageNum, Integer pageSize);
}
