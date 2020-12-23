/**
 * Project Name:springboot_hotel
 * File Name:CheckInfo.java
 * Package Name:cn.java.entity
 * Date:2020年7月10日上午9:46:44
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Description:入住信息 <br/>
 * Date: 2020年7月10日 上午9:46:44 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
public class CheckInfo implements Serializable {

    /**
     * serialVersionUID:(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = 4580626701829493772L;

    private Long id;// 主键

    private String roomNum;// 房间号

    @Pattern(regexp = ".{2,20}", message = "*姓名格式错误，请重新输入")
    @NotNull(message = "*姓名格式错误，请重新输入")
    private String customerName;// 顾客姓名

    @NotNull(message = "*性别格式错误")
    private String gender;// 性别

    @NotNull
    private String isMembership;// 是否是会员

    @Pattern(regexp = "\\d{17}[0-9X]", message = "*身份证号格式错误，请重新输入")
    @NotNull(message = "*身份证号格式错误，请重新输入")
    private String idcard;// 身份证号

    @Pattern(regexp = "1[3578]\\d{9}", message = "*手机号格式错误，请重新输入")

    @NotNull(message = "*手机号格式错误，请重新输入")
    private String phoneNum;// 手机号

    @DecimalMin(value = "0", message = "*押金必须为整数，请重新输入")
    @DecimalMax(value = "1000", message = "*押金必须为整数，请重新输入")
    private Float deposit;// 押金

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkDate;// 入住时间

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

    /**
     * roomNum.
     *
     * @return the roomNum
     */
    public String getRoomNum() {
        return roomNum;
    }

    /**
     * roomNum.
     *
     * @param roomNum the roomNum to set
     */
    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
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
     * isMembership.
     *
     * @return the isMembership
     */
    public String getIsMembership() {
        return isMembership;
    }

    /**
     * isMembership.
     *
     * @param isMembership the isMembership to set
     */
    public void setIsMembership(String isMembership) {
        this.isMembership = isMembership;
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
     * deposit.
     *
     * @return the deposit
     */
    public Float getDeposit() {
        return deposit;
    }

    /**
     * deposit.
     *
     * @param deposit the deposit to set
     */
    public void setDeposit(Float deposit) {
        this.deposit = deposit;
    }

    /**
     * checkDate.
     *
     * @return the checkDate
     */
    public Date getCheckDate() {
        return checkDate;
    }

    /**
     * checkDate.
     *
     * @param checkDate the checkDate to set
     */
    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    /**
     * 简单描述该方法的实现功能（可选）.
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CheckInfo [id=" + id + ", roomNum=" + roomNum + ", customerName=" + customerName + ", gender=" + gender
                + ", isMembership=" + isMembership + ", idcard=" + idcard + ", phoneNum=" + phoneNum + ", deposit="
                + deposit + ", checkDate=" + checkDate + "]";
    }

    /**
     * 简单描述该方法的实现功能（可选）.
     * 
     * @see java.lang.Object#toString()
     */

}
