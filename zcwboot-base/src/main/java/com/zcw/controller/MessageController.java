package com.zcw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @ClassName : MessageController
 * @Description : 控制器
 * @Author : Zhaocunwei
 * @Date: 2020-04-02 15:53
 */
@RestController
public class MessageController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping
    public String home(){
        return "https://blog.csdn.net/qq_32370913";
    }

    /**
     * 修改成Restful风格
     * @param msg
     * @return
     */
    @GetMapping("/echo/{message}")
    public String echo(@PathVariable("message")String msg){
        return "【ECHO】"+msg;
    }

    /**
     * 实现内置对象获取
     */
    @GetMapping("/object")
    public Object object(HttpServletRequest request, HttpServletResponse response){
        Map<String,String> map = new HashMap<>();
        map.put("客户端IP地址",request.getRemoteAddr());
        map.put("客户端响应编码",response.getCharacterEncoding());
        map.put("SessionID",request.getSession().getId());
        map.put("项目真实路径",request.getServletContext().getRealPath("/"));
        return map;
    }
    /**
     * 利用 ServletRequestAttributes形式获取内置对象
     */
    @GetMapping("/obj")
    public Object obj(){
        ServletRequestAttributes requestAttributes  = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpServletResponse response = requestAttributes.getResponse();

        Map<String,String> map = new HashMap<>();
        map.put("客户端IP地址:",request.getRemoteAddr());
        map.put("客户端响应编码:",response.getCharacterEncoding());
        map.put("SeesionID",request.getSession().getId());
        map.put("项目真实路径",request.getServletContext().getRealPath("/"));

        return map;
    }
    @GetMapping("/message")
    public Object message(){
        Map<String,String> map = new HashMap<String,String>();
        map.put("welcome.url",this.messageSource.getMessage("welcome.url",null, Locale.getDefault()));
        map.put("welcome.msg",this.messageSource.getMessage("welcome.msg",new Object[]{"zhaocunwei"},
                Locale.getDefault()));
        return map;
    }
}
