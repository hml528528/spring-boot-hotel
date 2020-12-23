/**
 * Project Name:springboot_hotel
 * File Name:OneMenu.java
 * Package Name:cn.java.entity
 * Date:2020年7月8日上午7:38:25
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Description: 一级菜单 <br/>
 * Date: 2020年7月8日 上午7:38:25 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
public class OneMenu implements Serializable {

    /**
     * serialVersionUID:(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = 6970015638462419919L;

    private Long id;// 一级菜单主键

    private String oneName;// 一级菜单名

    private List<TowMenu> towMenusList;

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
     * oneName.
     *
     * @return the oneName
     */
    public String getOneName() {
        return oneName;
    }

    /**
     * oneName.
     *
     * @param oneName the oneName to set
     */
    public void setOneName(String oneName) {
        this.oneName = oneName;
    }

    /**
     * towMenusList.
     *
     * @return the towMenusList
     */
    public List<TowMenu> getTowMenusList() {
        return towMenusList;
    }

    /**
     * towMenusList.
     *
     * @param towMenusList the towMenusList to set
     */
    public void setTowMenusList(List<TowMenu> towMenusList) {
        this.towMenusList = towMenusList;
    }

    /**
     * 简单描述该方法的实现功能（可选）.
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final int maxLen = 10;
        return "OneMenu [id=" + id + ", oneName=" + oneName + ", towMenusList="
                + (towMenusList != null ? towMenusList.subList(0, Math.min(towMenusList.size(), maxLen)) : null) + "]";
    }

}
