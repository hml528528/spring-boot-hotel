/**
 * Project Name:springboot_hotel
 * File Name:CheckOut.java
 * Package Name:cn.java.entity
 * Date:2020年7月16日下午3:12:49
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.entity;

import java.io.Serializable;

/**
 * Description: 封装退房信息 <br/>
 * Date: 2020年7月16日 下午3:12:49 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
public class CheckOut implements Serializable {

    /**
     * serialVersionUID:(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = -8238657571726742850L;

    private Long roomId;// 房间号

    private String customerName;// 顾客姓名

    private Float price;// 房间单价

    private Float deposit;// 押金

    private Float otherConsume;// 其他消费

    private String checkDate;// 入住时间

    private String checkoutDate;// 退房时间

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
     * price.
     *
     * @return the price
     */
    public Float getPrice() {
        return price;
    }

    /**
     * price.
     *
     * @param price the price to set
     */
    public void setPrice(Float price) {
        this.price = price;
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
     * otherConsume.
     *
     * @return the otherConsume
     */
    public Float getOtherConsume() {
        return otherConsume;
    }

    /**
     * otherConsume.
     *
     * @param otherConsume the otherConsume to set
     */
    public void setOtherConsume(Float otherConsume) {
        this.otherConsume = otherConsume;
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
     * checkoutDate.
     *
     * @return the checkoutDate
     */
    public String getCheckoutDate() {
        return checkoutDate;
    }

    /**
     * checkoutDate.
     *
     * @param checkoutDate the checkoutDate to set
     */
    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    /**
     * 简单描述该方法的实现功能（可选）.
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CheckOut [roomId=" + roomId + ", customerName=" + customerName + ", price=" + price + ", deposit="
                + deposit + ", otherConsume=" + otherConsume + ", checkDate=" + checkDate + ", checkoutDate="
                + checkoutDate + "]";
    }

}
