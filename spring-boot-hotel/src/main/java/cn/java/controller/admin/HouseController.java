/**
 * Project Name:springboot_hotel
 * File Name:HouseController.java
 * Package Name:cn.java.controller.admin
 * Date:2020年7月16日下午8:42:50
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.controller.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.java.service.HouseService;

/**
 * Description: 房间管理模块 <br/>
 * Date: 2020年7月16日 下午8:42:50 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
@Controller
public class HouseController {
    @Autowired
    private HouseService houseService;

    /**
     * 
     * Description:查询所有客房信息 <br/>
     *
     * @author HML
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping("/getHouseInfo.do")
    public String getHouseInfo(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize, Model model) {
        List<Map<String, Object>> houseInfoList = houseService.selectHouseInfo(pageNum, pageSize);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(houseInfoList);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/room/houseinfo.jsp";
    }

    /**
     * 
     * Description:查询房间类型 <br/>
     *
     * @author HML
     * @return
     */
    @RequestMapping("/getHouseTypeInfo.do")
    @ResponseBody
    public List<Map<String, Object>> getHouseTypeInfo(Model model) {
        List<Map<String, Object>> houseTypeList = houseService.selectHouseType();
        model.addAttribute("houseTypeList", houseTypeList);
        return houseTypeList;
    }

    /**
     * 
     * Description:根据条件查询房间信息 <br/>
     *
     * @author HML
     * @return
     */
    @RequestMapping("/getHouseInfoByCondition.do")
    public String getHouseInfoByCondition(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize, Model model, String type,
            String keyword) {
        List<Map<String, Object>> houseInfoList = houseService.selectHouseInfoByCondition(pageNum, pageSize, type,
                keyword);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(houseInfoList);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/room/houseinfo.jsp";
    }

    /**
     * 
     * Description:判断房间号是否存在 <br/>
     *
     * @author HML
     * @param roomNum
     * @return
     */
    @RequestMapping("/getRoomNums.do")
    @ResponseBody
    public boolean getRoomNums(String roomNum) {
        System.out.println("-------------" + roomNum);

        return houseService.selectRoomNums(roomNum);
    }

    /**
     * 
     * Description: 添加房间信息<br/>
     *
     * @author HML
     * @return
     */
    @RequestMapping("/addHouse.do")
    public String addHouse(String roomNum, String roomStatus, Long roomTypeId) {
        boolean flag = houseService.addHouseInfo(roomNum, roomStatus, roomTypeId);
        if (flag) {
            return "redirect:/getHouseInfo.do";
        } else {
            return "admin/room/addhouse.jsp";
        }

    }

    /**
     * 
     * Description:客房管理 <br/>
     *
     * @author HML
     * @return
     */
    @RequestMapping("/HouseManage.do")
    public String HouseManage(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize, Model model) {
        List<Map<String, Object>> houseTypeList = houseService.selectHouseType();
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(houseTypeList);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/room/housemanage.jsp";
    }
}
