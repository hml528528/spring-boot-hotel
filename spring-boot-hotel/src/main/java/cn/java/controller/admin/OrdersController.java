/**
 * Project Name:springboot_hotel
 * File Name:OrdersController.java
 * Package Name:cn.java.controller.admin
 * Date:2020年7月11日上午10:12:40
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

import cn.java.entity.Order;
import cn.java.service.OrderService;

/**
 * Description: 订单模块 <br/>
 * Date: 2020年7月11日 上午10:12:40 <br/>
 * 
 * @author HML
 * @version
 * @see
 */
@Controller
public class OrdersController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/ordersadd.do")
    public String ordersadd(Model model) {
        List<Map<String, Object>> numList = orderService.selectroomNum();
        model.addAttribute("numList", numList);
        return "admin/order/addorders.jsp";
    }

    @RequestMapping("/addorders.do")
    public String addorders(@Valid Order order, BindingResult erroResult, HttpSession session, Long roomId) {
        System.out.println(order);
        // 判断是否有错
        boolean flag = erroResult.hasFieldErrors();
        // 将错误信息封装到errorMap中
        Map<String, Object> errorMap = new HashMap<String, Object>();
        if (flag) {// 有错
            // 获取字段错误信息
            List<FieldError> fieldErrors = erroResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                // 获取字段信息
                String field = fieldError.getField();
                // 获取错误信息
                String message = fieldError.getDefaultMessage();
                errorMap.put(field, message);
            }
            session.setAttribute("errorMap", errorMap);
            session.setAttribute("order", order);
            return "redirect:/ordersadd.do";
        } else {// 没有错误
            boolean flag2 = orderService.addOders(order);
            if (flag2) {
                return "redirect:/getorders.do";
            } else {
                return "redirect:/ordersadd.do";
            }
        }
    }

    @RequestMapping("/getorders.do")
    public String getorders(HttpSession session) {
        List<Map<String, Object>> ordersList = orderService.getOrders();
        session.setAttribute("ordersList", ordersList);
        return "admin/order/orderinfo.jsp";
    }

    @RequestMapping("/findOrders.do")
    public String findOrders(String type, String keyword, HttpSession session) {
        List<Map<String, Object>> ordersList = orderService.getOrdersBycondition(type, keyword);
        session.setAttribute("ordersList", ordersList);
        return "redirect:/pages/admin/order/orderinfo_condition.jsp";
    }

}
