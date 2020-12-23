/**
 * Project Name:springboot_hotel
 * File Name:Membership.java
 * Package Name:cn.java.entity
 * Date:2020年7月15日下午3:16:20
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Description: 会员管理模块 <br/>
 * Date: 2020年7月15日 下午3:16:20 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
public class Membership implements Serializable {

    /**
     * serialVersionUID:(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = 4482881765566898353L;

    private Long id;

    /**
     * id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * id.
     *
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    private String membershipNum;// 会员编号

    @Pattern(regexp = ".{2,20}", message = "*姓名格式错误，请重新输入")
    @NotNull(message = "*姓名格式错误，请重新输入")
    private String customerName;// 会员名称

    @NotNull(message = "*性别格式错误")
    private String gender;// 性别

    private Float discount = 0.95F;// 折扣

    @Pattern(regexp = "\\d{17}[0-9X]", message = "*身份证号格式错误，请重新输入")
    @NotNull(message = "*身份证号格式错误，请重新输入")
    private String idcard;// 身份证号

    @Pattern(regexp = "1[3578]\\d{9}", message = "*手机号格式错误，请重新输入")
    @NotNull(message = "*手机号格式错误，请重新输入")
    private String phoneNum;// 手机号

    private String createDate;// 创建日期

    /**
     * membershipNum.
     *
     * @return the membershipNum
     */
    public String getMembershipNum() {
        return membershipNum;
    }

    /**
     * membershipNum.
     *
     * @param membershipNum the membershipNum to set
     */
    public void setMembershipNum(String membershipNum) {
        this.membershipNum = membershipNum;
    }

    /**
     * customerName.
     *
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * customerName.
     *
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * gender.
     *
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * discount.
     *
     * @return the discount
     */
    public Float getDiscount() {
        return discount;
    }

    /**
     * discount.
     *
     * @param discount the discount to set
     */
    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    /**
     * idcard.
     *
     * @return the idcard
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * idcard.
     *
     * @param idcard the idcard to set
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    /**
     * phoneNum.
     *
     * @return the phoneNum
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * phoneNum.
     *
     * @param phoneNum the phoneNum to set
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     * createDate.
     *
     * @return the createDate
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * createDate.
     *
     * @param createDate the createDate to set
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /**
     * 简单描述该方法的实现功能（可选）.
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Membership [id=" + id + ", membershipNum=" + membershipNum + ", customerName=" + customerName
                + ", gender=" + gender + ", discount=" + discount + ", idcard=" + idcard + ", phoneNum=" + phoneNum
                + ", createDate=" + createDate + "]";
    }

    /**
     * 简单描述该方法的实现功能（可选）.
     * 
     * @see java.lang.Object#toString()
     */

}
