/**
 * Project Name:springboot_hotel
 * File Name:Task.java
 * Package Name:cn.java.tasks
 * Date:2020年7月26日上午11:24:31
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Description: 定时器任务 <br/>
 * Date: 2020年7月26日 上午11:24:31 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
@Component
public class Task {
    // 在固定时间执行
    // @Scheduled(fixedRate = 1000)
    // 在指定时间执行
    @Scheduled(cron = "0/2 35 11 * * *")
    public void test() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
    }
}
