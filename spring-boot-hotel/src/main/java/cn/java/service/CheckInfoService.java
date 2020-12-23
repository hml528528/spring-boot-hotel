/**
 * Project Name:springboot_hotel
 * File Name:CheckInfoService.java
 * Package Name:cn.java.service.impl
 * Date:2020年7月8日下午7:58:23
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.service;

import java.util.List;
import java.util.Map;

import cn.java.entity.CheckInfo;
import cn.java.entity.CheckOut;

/**
 * Description:入住信息管理模块 <br/>
 * Date: 2020年7月8日 下午7:58:23 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
public interface CheckInfoService {
    /**
     * 
     * Description:分页查询入住所有信息 <br/>
     *
     * @author HML
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Map<String, Object>> selectCheckInfos(Integer pageNum, Integer pageSize);

    /**
     * 
     * Description:根据具体条件查询 入住信息<br/>
     *
     * @author HML
     * @param type
     * @param keyword
     * @return
     */
    List<Map<String, Object>> selectCheckInfosBycondition(String type, String keyword);

    /**
     * 
     * Description:根据id删除入住信息 <br/>
     *
     * @author HML
     * @param id
     * @return
     */

    boolean deleteCheckInfoByid(Long id);

    /**
     * 
     * Description:根据id批量删除入住信息 <br/>
     *
     * @author HML
     * @param id
     * @return
     */
    boolean batchDelete(String idStrr);

    /**
     * 
     * Description:查询所有房间号 <br/>
     *
     * @author HML
     * @return
     */
    List<Map<String, Object>> selectRoomNums();

    /**
     * 
     * Description: 添加入住信息<br/>
     *
     * @author HML
     * @param checkInfo
     * @return
     */
    boolean saveCheckInfo(CheckInfo checkInfo);

    /**
     * 
     * Description:查询所有已入住的房间号 <br/>
     *
     * @author HML
     * @return
     */
    List<Map<String, Object>> selectCheckRoomNum();

    /**
     * 
     * Description:根据房间号查询入住的详细信息 <br/>
     *
     * @author HML
     * @param id
     * @return
     */
    Map<String, Object> detailCheckInfo(Long roomId);

    /**
     * 
     * Description: 通过房间id查询房间单价<br/>
     *
     * @author HML
     * @param roomNum
     * @return
     */
    Float getroompriceByroomNum(Long id);

    /**
     * 
     * Description: 结账退房<br/>
     *
     * @author HML
     * @param checkOut
     * @return
     */
    Float checkout(CheckOut checkOut) throws Exception;
}
