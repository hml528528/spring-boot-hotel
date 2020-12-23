/**
 * Project Name:springboot_hotel
 * File Name:Order.java
 * Package Name:cn.java.entity
 * Date:2020年7月11日下午2:05:57
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.entity;

import java.io.Serializable;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

/**
 * Description:订单模块 <br/>
 * Date: 2020年7月11日 下午2:05:57 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
public class Order implements Serializable {

    /**
     * serialVersionUID:(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = -6009386827414802663L;

    private Long id;// 主键

    private String orderNum;// 订单编号

    private String customerName;// 顾客姓名

    private String idcard;// 身份证号

    private String phoneNum;// 手机号

    @NotNull(message = "*押金必须为整数，请重新输入")
    @DecimalMin(value = "0", message = "*押金必须为整数，请重新输入")
    @DecimalMax(value = "1000", message = "*押金必须为整数，请重新输入")
    private Float total;// 订单总价

    private String checkDate;// 创建订单时间

    @NotNull(message = "*订单状态格式不正确")
    private String orderStatus;// 订单状态

    private Long roomId;// 房间主键

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
     * orderNum.
     *
     * @return the orderNum
     */
    public String getOrderNum() {
        return orderNum;
    }

    /**
     * orderNum.
     *
     * @param orderNum the orderNum to set
     */
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * total.
     *
     * @return the total
     */
    public Float getTotal() {
        return total;
    }

    /**
     * total.
     *
     * @param total the total to set
     */
    public void setTotal(Float total) {
        this.total = total;
    }

    /**
     * checkDate.
     *
     * @return the checkDate
     */
    public String getCheckDate() {
        return checkDate;
    }

    /**
     * checkDate.
     *
     * @param checkDate the checkDate to set
     */
    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    /**
     * orderStatus.
     *
     * @return the orderStatus
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * orderStatus.
     *
     * @param orderStatus the orderStatus to set
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * roomId.
     *
     * @return the roomId
     */
    public Long getRoomId() {
        return roomId;
    }

    /**
     * roomId.
     *
     * @param roomId the roomId to set
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
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
     * 简单描述该方法的实现功能（可选）.
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Order [id=" + id + ", orderNum=" + orderNum + ", customerName=" + customerName + ", idcard=" + idcard
                + ", phoneNum=" + phoneNum + ", total=" + total + ", checkDate=" + checkDate + ", orderStatus="
                + orderStatus + ", roomId=" + roomId + "]";
    }

}
