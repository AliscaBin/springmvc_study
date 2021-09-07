package com.wangbin.springmvc2.controller;

import com.wangbin.springmvc2.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/userRegister")
    public String userRegister(User user){
        System.out.println(user);
        return "success";
    }

    @RequestMapping(value = "/testmav")
    public ModelAndView testModeAndView(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("testScope", "hellp,ModeAndView");
        mav.setViewName("success");
        return mav;
    }
}
