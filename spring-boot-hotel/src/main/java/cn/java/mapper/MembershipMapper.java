/**
 * Project Name:springboot_hotel
 * File Name:MembershipController.java
 * Package Name:cn.java.mapper
 * Date:2020年7月15日上午11:20:35
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.java.entity.Membership;

/**
 * Description: 会员管理模块 <br/>
 * Date: 2020年7月15日 上午11:20:35 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
public interface MembershipMapper {
    /**
     * 
     * Description:查询所有会员信息 <br/>
     *
     * @author HML
     * @return
     */
    @Select("SELECT * FROM membership")
    List<Map<String, Object>> getMembershipInfo();

    /**
     * 
     * Description:根据idcard判断用户是否存在 <br/>
     *
     * @author HML
     * @param idcard
     * @return
     */
    @Select("SELECT COUNT(*) FROM membership WHERE idcard=#{arg0}")
    int getMembershipByidcard(String idcard);

    /**
     * 
     * Description: 添加会员信息<br/>
     *
     * @author HML
     * @param membership
     * @return
     */
    @Insert("\r\n"
            + "INSERT INTO membership SET membership_num=#{membershipNum},customer_name=#{customerName},gender=#{gender},discount=#{discount},idcard=#{idcard},phone_num=#{phoneNum},create_date=#{createDate}")
    int addMembershipInfo(Membership membership);

    /**
     * 
     * Description:通过id查询会员详细信息 <br/>
     *
     * @author HML
     * @param id
     * @return
     */
    @Select("SELECT * FROM membership WHERE id=#{arg0}")
    Map<String, Object> getMembershipInfoByid(Long id);

    /**
     * 
     * Description:根据 id修改会员信息<br/>
     *
     * @author HML
     * @param membership
     * @return
     */
    @Update("UPDATE membership SET customer_name=#{customerName},gender=#{gender},discount=#{discount},idcard=#{idcard},phone_num=#{phoneNum} WHERE id=#{id}")
    int updateMembershipInfoByid(Membership membership);
}
