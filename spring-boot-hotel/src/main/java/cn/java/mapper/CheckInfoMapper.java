/**
 * Project Name:springboot_hotel
 * File Name:CheckInfoMapper.java
 * Package Name:cn.java.mapper
 * Date:2020年7月8日下午7:44:13
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.java.entity.CheckInfo;

/**
 * Description:入住信息 <br/>
 * Date: 2020年7月8日 下午7:44:13 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
public interface CheckInfoMapper {
    /**
     * 
     * Description: 获取全部入住信息<br/>
     *
     * @author HML
     * @return
     */
    List<Map<String, Object>> getCheckInfos();

    /**
     * 
     * Description: 根据指定条件获取入住信息<br/>
     *
     * @author HML
     * @param type
     * @param keyword
     * @return
     */

    List<Map<String, Object>> getCheckInfosBycondition(String type, String keyword);

    /**
     * 
     * Description:根据id删除入住信息 <br/>
     *
     * @author HML
     * @param id
     * @return
     */

    @Update("UPDATE room_check SET STATUS=0 WHERE id=#{arg0}")
    int deleteCheckInfoByid(Long id);

    /**
     * 
     * Description:根据id批量删除入住信息 <br/>
     *
     * @author HML
     * @param idStrr
     * @return
     */

    @Update("UPDATE room_check SET STATUS=0 WHERE id IN (${idStrr})")
    int batchDelete(@Param("idStrr") String idStrr);

    /**
     * 
     * Description:查询所有房间号 <br/>
     *
     * @author HML
     * @return
     */
    @Select("SELECT * FROM rooms Where room_status=0")
    List<Map<String, Object>> getRoomNums();

    /**
     * 
     * Description:通过房间号查询id <br/>
     *
     * @author HML
     * @param roomNum
     * @return
     */
    @Select("SELECT id FROM rooms WHERE room_num=#{roomNum}")
    Long getIdByroomNum(String roomNum);

    /**
     * 
     * Description:添加入住信息 <br/>
     *
     * @author HML
     * @param checkInfo
     * @return
     */
    @Insert("INSERT INTO room_check SET customer_name=#{customerName},gender=#{gender},is_membership=#{isMembership},idcard=#{idcard},phone_num=#{phoneNum},deposit=#{deposit},check_date=#{checkDate},room_id=#{id},`status`='1'")
    int insertCheckInfo(CheckInfo checkInfo);

    /**
     * 
     * Description:根据id更新房间状态 <br/>
     *
     * @author HML
     * @param id
     * @return
     */
    @Update("UPDATE rooms SET room_status=1 WHERE id=#{arg0}")
    int updateCheckInfostatusByid(Long id);

    /**
     * 
     * Description:查询所有已入住的房间号 <br/>
     *
     * @author HML
     * @return
     */
    @Select("SELECT id,room_num FROM rooms WHERE room_status=1")
    List<Map<String, Object>> getCheckRoomNum();

    /**
     * 
     * Description:根据房间号查询入住的详细信息 <br/>
     *
     * @author HML
     * @param id
     * @return
     */
    @Select("SELECT  customer_name,idcard,phone_num,gender,deposit,DATE_FORMAT(check_date,\"%Y-%m-%d\") AS check_date FROM `room_check` WHERE room_id=#{arg0}")
    Map<String, Object> detailCheckInfo(Long roomId);

    /**
     * 
     * Description: 通过房间id查询房间单价<br/>
     *
     * @author HML
     * @param roomNum
     * @return
     */
    @Select("SELECT room_price FROM room_type WHERE id=(SELECT room_type_id FROM rooms WHERE id=#{arg0})\r\n" + "")
    Float getroompriceByroomid(Long id);

    /**
     * 
     * Description:根据房间id查询其他消费 <br/>
     *
     * @author HML
     * @param roomId
     * @return
     */
    @Select("SELECT SUM(total) AS other_consume FROM orders WHERE room_id=#{arg0} AND order_status=0")
    Float getotherConsume(Long roomId);

    /**
     * 
     * Description:根据身份证号判断顾客是否是会员 <br/>
     *
     * @author HML
     * @param roomId
     * @return
     */
    @Select("SELECT discount FROM membership WHERE idcard=( SELECT idcard FROM room_check WHERE room_id=#{arg0})")
    Float getdiscountByroomid(Long roomId);

    /**
     * 
     * Description:根据房间id修改房间状态 <br/>
     *
     * @author HML
     * @param idcard
     * @return
     */
    @Update("UPDATE rooms SET room_status=2 WHERE id=#{arg0}")
    int updateroomStatusByrooId(Long roomId);

    /**
     * 
     * Description: 根据房间ID修改退房状态<br/>
     *
     * @author HML
     * @param roomId
     * @return
     */
    @Update("UPDATE room_check SET checkout_status='1' WHERE room_id=#{arg0}")
    int upadtecheckoutStatusByroomId(Long roomId);
}
