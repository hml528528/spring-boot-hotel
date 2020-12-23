/**
 * Project Name:springboot_hotel
 * File Name:TowMenu.java
 * Package Name:cn.java.entity
 * Date:2020年7月8日上午7:40:34
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.entity;

import java.io.Serializable;

/**
 * Description: 二级菜单 <br/>
 * Date: 2020年7月8日 上午7:40:34 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
public class TowMenu implements Serializable {

    /**
     * serialVersionUID:(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = -6229368672915426619L;

    private Long towMenuId;

    private String towName;// 二级菜单名

    private String url;// 二级菜单链接

    private Long parentLimitId;// 一级菜单id

    /**
     * towMenuId.
     *
     * @return the towMenuId
     */
    public Long getTowMenuId() {
        return towMenuId;
    }

    /**
     * towMenuId.
     *
     * @param towMenuId the towMenuId to set
     */
    public void setTowMenuId(Long towMenuId) {
        this.towMenuId = towMenuId;
    }

    /**
     * towName.
     *
     * @return the towName
     */
    public String getTowName() {
        return towName;
    }

    /**
     * towName.
     *
     * @param towName the towName to set
     */
    public void setTowName(String towName) {
        this.towName = towName;
    }

    /**
     * url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * url.
     *
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * parentLimitId.
     *
     * @return the parentLimitId
     */
    public Long getParentLimitId() {
        return parentLimitId;
    }

    /**
     * parentLimitId.
     *
     * @param parentLimitId the parentLimitId to set
     */
    public void setParentLimitId(Long parentLimitId) {
        this.parentLimitId = parentLimitId;
    }

    /**
     * 简单描述该方法的实现功能（可选）.
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TowMenu [towMenuId=" + towMenuId + ", towName=" + towName + ", url=" + url + ", parentLimitId="
                + parentLimitId + "]";
    }

}
