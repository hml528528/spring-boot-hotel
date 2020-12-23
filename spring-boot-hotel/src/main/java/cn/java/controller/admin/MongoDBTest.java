/**
 * Project Name:springboot_hotel
 * File Name:MongoDBTest.java
 * Package Name:cn.java.controller.admin
 * Date:2020年7月26日上午9:45:25
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.java.entity.MongoDB;

/**
 * Description: MongoDB测试 <br/>
 * Date: 2020年7月26日 上午9:45:25 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
@Controller
public class MongoDBTest {
    @Autowired
    private MongoOperations mongoOperations;

    @RequestMapping("/insertdata2MongoDB.do")
    public void insertdata2MongoDB() {
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 200000; i++) {
            MongoDB mongodb = new MongoDB("李四", "123456");
            mongoOperations.save(mongodb);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("共花费" + (endTime - startTime) + "ms");
    }
}
