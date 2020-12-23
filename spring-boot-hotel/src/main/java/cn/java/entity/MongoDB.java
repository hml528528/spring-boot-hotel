/**
 * Project Name:springboot_hotel
 * File Name:MongoDB.java
 * Package Name:cn.java.entity
 * Date:2020年7月26日上午9:59:23
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.entity;

import java.io.Serializable;

/**
 * Description: mongodb <br/>
 * Date: 2020年7月26日 上午9:59:23 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
public class MongoDB implements Serializable {
    /**
     * serialVersionUID:(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = 8215787202060962230L;

    private String useranme;

    private String password;

    /**
     * useranme.
     *
     * @return the useranme
     */
    public String getUseranme() {
        return useranme;
    }

    /**
     * useranme.
     *
     * @param useranme the useranme to set
     */
    public void setUseranme(String useranme) {
        this.useranme = useranme;
    }

    /**
     * password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * password.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 简单描述该方法的实现功能（可选）.
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MongoDB [useranme=" + useranme + ", password=" + password + "]";
    }

    public MongoDB(String useranme, String password) {
        super();
        this.useranme = useranme;
        this.password = password;
    }

    public MongoDB() {

        super();
        // Auto-generated constructor stub

    }

}
