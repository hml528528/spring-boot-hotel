/**
 * Project Name:springboot_hotel
 * File Name:StartApplication.java
 * Package Name:cn.java.controller.application
 * Date:2020年7月7日下午3:09:10
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.controller.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Description: 启动项目 <br/>
 * Date: 2020年7月7日 下午3:09:10 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
@SpringBootApplication(scanBasePackages = { "cn.java.controller.*", "cn.java.service.impl", "cn.java.tasks" })
@MapperScan(basePackages = { "cn.java.mapper" })
// 开启redis
@EnableCaching
// 开启定时器任务
@EnableScheduling
public class StartApplication {

    public static void main(String[] args) {
        // 启动框架
        SpringApplication.run(StartApplication.class, args);
    }
}
