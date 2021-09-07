package com.wangbin.springstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
public class ErrorController {

//    @ExceptionHandler(ArithmeticException.class)
//    public String handleArithmeticException(Exception ex, Model model) {
//        model.addAttribute("ex", ex);
//        return "error";
//    }


}
