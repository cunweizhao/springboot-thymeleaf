package com.zcw.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName : SampleController
 * @Description :
 * @Author : Zhaocunwei
 * @Date: 2020-04-02 15:44
 */
@Controller
@EnableAutoConfiguration
public class SampleController {
    @RequestMapping("/")
    @ResponseBody
    public String home(){
        return "https://blog.csdn.net/qq_32370913";
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleController.class,args);
    }
}
