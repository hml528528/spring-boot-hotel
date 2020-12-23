/**
 * Project Name:chapter_MD5Tool
 * File Name:MD5Tools.java
 * Package Name:cn.java.tools
 * Date:2020年6月27日下午6:18:12
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.utils;

import java.security.MessageDigest;

/**
 * Description:数据加密工具 <br/>
 * Date: 2020年6月27日 下午6:18:12 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
public class MD5Tools {
    private static final String[] digital = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e",
            "f" };

    public static String md5(String password) throws Exception {
        String encry = "";
        // 获取MD5算法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] digest = md5.digest(password.getBytes("UTF-8"));
        for (byte b : digest) {
            int num = b;
            if (num < 0) {
                num = num + 256;
            }
            int index1 = num / 16;
            int index2 = num % 16;
            encry += digital[index1] + digital[index2];
        }
        return encry;
    }

    /**
     * 
     * Description:二次加密 <br/>
     *
     * @author HML
     * @param password
     * @return
     * @throws Exception
     */
    public static String encey(String password) throws Exception {
        return md5(md5(password) + password);
    }

    /*
     * public static void main(String[] args) throws Exception { String password
     * = "123456"; String encey = MD5Tools.encey(password);
     * System.out.println(encey); }
     */
}
