package com.wangbin.study03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ScopeController {

    @RequestMapping(value = "testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request){
        request.setAttribute("testScope","hello, servlet api");
        return "success";
    }

    @RequestMapping(value = "testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("testScope", "hello, ModelAndView");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "testModel")
    public String testModel(Model model){
        model.addAttribute("testScope", "hello, Model");
        return "success";
    }

    @RequestMapping(value = "testMap")
    public String testMap(Map<String, Object> map) {
        map.put("testScope", "hello, Map");
        return "success";
    }

    @RequestMapping(value = "testModelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("testScope", "hello, ModelMap");
        return "success";
    }

    @RequestMapping(value = "testHttpSession")
    public String testHttpSession(HttpSession session) {
        session.setAttribute("testScope", "hello, HttpSession");
        return "success";
    }

    @RequestMapping(value = "testServletContext")
    public String testServletContext(HttpSession session) {
        ServletContext context = session.getServletContext();
        context.setAttribute("testScope", "hello, ServletContext");
        return "success";
    }
}
