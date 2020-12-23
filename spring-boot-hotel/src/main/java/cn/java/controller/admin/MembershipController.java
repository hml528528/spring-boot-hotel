/**
 * Project Name:springboot_hotel
 * File Name:MembershipController.java
 * Package Name:cn.java.controller.admin
 * Date:2020年7月15日上午10:25:00
 * Copyright (c) 2020, bluemobi All Rights Reserved.
 *
*/

package cn.java.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.java.entity.Membership;
import cn.java.service.MembershipService;

/**
 * Description: 会员管理模块 <br/>
 * Date: 2020年7月15日 上午10:25:00 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
@Controller
public class MembershipController {
    @Autowired
    private MembershipService membershipService;

    @RequestMapping("/getmembership.do")
    public String getmembership(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize, Model model) {
        List<Map<String, Object>> membershipInfoList = membershipService.selectMembershipInfo(pageNum, pageSize);
        // 将查询的信息封装到pageinfo中
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(membershipInfoList);
        model.addAttribute("pageInfo", pageInfo);

        return "admin/vip/vipinfo.jsp";

    }

    @RequestMapping("/addmembership.do")
    public String addmembership(@Valid Membership membership, BindingResult errorResult, Model model) {

        // 判断是否有误
        boolean flag = errorResult.hasErrors();
        if (flag) {// 有误
            // 创建Map集合封装错误信息
            Map<String, Object> errorMap = new HashMap<String, Object>();
            // 获取错误信息
            List<FieldError> fieldErrors = errorResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                String field = fieldError.getField();
                String message = fieldError.getDefaultMessage();
                errorMap.put(field, message);
            }
            model.addAttribute("errorMap", errorMap);
            model.addAttribute("membership", membership);
            return "admin/vip/addvip.jsp";
        } else {// 格式完全正确
            // 调用业务方法
            boolean flag2 = membershipService.addMembershipInfo(membership);
            if (flag2) {
                return "redirect:/getmembership.do";
            } else {
                return "admin/vip/addvip.jsp";
            }

        }
    }

    @RequestMapping("/getMembershipByid.do")
    public String getMembershipByid(Long id, Model model) {
        Map<String, Object> membershipInfoMap = membershipService.selectMembershipInfoByid(id);
        model.addAttribute("membershipInfoMap", membershipInfoMap);
        return "admin/vip/updatevip.jsp";

    }

    @RequestMapping("/getMembershipInfoByid.do")
    public String getMembershipInfoByid(Membership membership) {
        boolean flag = membershipService.updateMembershipInfoByid(membership);
        if (flag) {
            return "redirect:/getmembership.do";
        } else {
            return "admin/vip/updatevip.jsp";
        }

    }
}
