package com.angenin.springboot.controller;

import com.angenin.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @package_name: com.angenin.springboot.controller
 * @name: LoginController
 * @author: angenin
 * @dateTime: 2020/12/13 下午1:43
 **/
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    //    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @PostMapping("/user/login")    //直接使用PostMapping表示要映射一个post的请求
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession httpSession){

        if (userService.isExist(username, password)) {
            //把用户名保存到session域中
            httpSession.setAttribute("loginUser", username);
            //登录成功跳转到dashboard.html页面
            return "redirect:/main.html";
        } else {
            map.put("msg", "用户名或密码错误");
            return "login";
        }
    }
}