/**
 * Project Name:springboot_hotel
 * File Name:CheckInfoController.java
 * Package Name:cn.java.controller.admin
 * Date:2020年7月8日下午7:59:01
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.java.entity.CheckInfo;
import cn.java.entity.CheckOut;
import cn.java.service.CheckInfoService;

/**
 * Description: 入住信息管理 <br/>
 * Date: 2020年7月8日 下午7:59:01 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
@Controller
public class CheckInfoController {
    @Autowired
    private CheckInfoService checkInfoService;

    @RequestMapping("/getInfo.do")
    public String getInfo(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize, Model model) {

        List<Map<String, Object>> CheckInfos = checkInfoService.selectCheckInfos(pageNum, pageSize);
        // 将CheckInfos封装到pageInfo中去
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(CheckInfos);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/bill/inroominfo.jsp";
    }

    @RequestMapping("/getInfoBycondition.do")
    public String getInfoBycondition(String type, String keyword, Model model) {
        List<Map<String, Object>> checkList = checkInfoService.selectCheckInfosBycondition(type, keyword);
        model.addAttribute("checkList", checkList);
        return "/admin/bill/inroominfo_condition.jsp";
    }

    @RequestMapping("/deleteByid.do")
    @ResponseBody
    public boolean deleteByid(Long id) {
        boolean delete = checkInfoService.deleteCheckInfoByid(id);

        return delete;
    }

    @RequestMapping("/batchDel.do")
    @ResponseBody
    public boolean batchDel(String idStrr) {
        boolean delete = checkInfoService.batchDelete(idStrr);

        return delete;
    }

    @RequestMapping("/checkInfoAdd.do")
    public String checkInfoAdd(Model model) {
        List<Map<String, Object>> RoomNumsList = checkInfoService.selectRoomNums();
        model.addAttribute("RoomNumsList", RoomNumsList);
        return "admin/bill/checkin.jsp";
    }

    @RequestMapping("/addCheckInfos.do")
    public String addCheckInfos(@Valid CheckInfo checkinfo, BindingResult erroResult, HttpSession session) {
        System.out.println("-----------" + checkinfo + "-----------------");
        // 判断是否有错
        boolean flag = erroResult.hasErrors();
        if (flag) {// 有错
            Map<String, Object> errorMap = new HashMap<String, Object>();
            // 获取错误信息
            List<FieldError> fieldErrors = erroResult.getFieldErrors();
            // 遍历
            for (FieldError fieldError : fieldErrors) {
                // 获取字段信息
                String field = fieldError.getField();
                // 获取字段错误信息
                String message = fieldError.getDefaultMessage();
                errorMap.put(field, message);
            }
            session.setAttribute("errorMap", errorMap);
            session.setAttribute("checkinfo", checkinfo);
            return "redirect:/checkInfoAdd.do";
        } else {// 信息完全正确
            boolean f = checkInfoService.saveCheckInfo(checkinfo);
            if (f) {// 添加成功
                return "redirect:/getInfo.do";
            } else {// 添加失败
                return "redirect:/checkInfoAdd.do";
            }

        }

    }

    @RequestMapping("/checkout.do")
    public String checkout(Model model) {
        List<Map<String, Object>> RoomNumsList = checkInfoService.selectCheckRoomNum();
        model.addAttribute("RoomNumsList", RoomNumsList);
        return "admin/bill/out.jsp";
    }

    @RequestMapping("/getdetailcheckInfo.do")
    @ResponseBody
    public Map<String, Object> getdetailcheckInfo(Long roomId) {
        Map<String, Object> checkInfoMap = checkInfoService.detailCheckInfo(roomId);
        Float price = checkInfoService.getroompriceByroomNum(roomId);
        checkInfoMap.put("room_price", price);

        return checkInfoMap;
    }

    @RequestMapping("/Checkout.do")
    @ResponseBody
    public Float Checkout(CheckOut checkOut) throws Exception {
        System.out.println(checkOut);
        Float checkout2 = checkInfoService.checkout(checkOut);
        return checkout2;
    }

}
