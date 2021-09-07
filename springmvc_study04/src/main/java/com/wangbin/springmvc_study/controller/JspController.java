package com.wangbin.springmvc_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {
    @RequestMapping(value = "/success")
    public String success(){
        return "success";
    }
}
