/**
 * Project Name:springboot_hotel
 * File Name:MembershipService.java
 * Package Name:cn.java.service
 * Date:2020年7月15日上午11:23:24
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.service;

import java.util.List;
import java.util.Map;

import cn.java.entity.Membership;

/**
 * Description: 会员管理模块 <br/>
 * Date: 2020年7月15日 上午11:23:24 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
public interface MembershipService {
    /**
     * 
     * Description:查询所有会员信息 <br/>
     *
     * @author HML
     * @return
     */
    List<Map<String, Object>> selectMembershipInfo(Integer pageNum, Integer pageSize);

    /**
     * 
     * Description: 添加会员信息<br/>
     *
     * @author HML
     * @param membership
     * @return
     */
    boolean addMembershipInfo(Membership membership);

    /**
     * 
     * Description:通过id查询会员详细信息 <br/>
     *
     * @author HML
     * @param id
     * @return
     */
    Map<String, Object> selectMembershipInfoByid(Long id);

    /**
     * 
     * Description:根据 id修改会员信息<br/>
     *
     * @author HML
     * @param membership
     * @return
     */
    boolean updateMembershipInfoByid(Membership membership);
}
