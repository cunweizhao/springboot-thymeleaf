package com.zcw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName : ThymeleafController
 * @Description : Thyemelaf模板跳转类
 * @Author : Zhaocunwei
 * @Date: 2020-04-02 16:54
 */
@Controller
public class ThymeleafController {

    @GetMapping("/view")
    public String view(String mid, Model model){
        //request 属性传递包装
        model.addAttribute("url","https://blog.csdn.net/qq_32370913");
        model.addAttribute("mid",mid);
        return "message/message_show";//返回一个路径，该路径后缀默认是*.html
    }
}
