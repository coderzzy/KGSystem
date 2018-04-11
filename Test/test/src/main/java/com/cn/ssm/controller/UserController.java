package com.cn.ssm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cn.ssm.pojo.User;
import com.cn.ssm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping("userShow")
    public String toIndex(HttpServletRequest request,Model model){
    	// System.out.println("com.cn.ssm.controller.UserController(Object).toIndex1");
        int userId = Integer.parseInt(request.getParameter("id"));

        User user = userService.getUserById(userId);

        model.addAttribute("user", user);

        // System.out.println("com.cn.ssm.controller.UserController(Object).toIndex2");
        // System.out.println(user.getUserName());
        return "showUser";
    }

}