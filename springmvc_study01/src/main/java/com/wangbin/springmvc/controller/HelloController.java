package com.wangbin.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }
    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
}
