package com.wangbin.study03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    /**
     * 使用RESTFul模拟用户资源胡增删改查
     * /user        GET     查询所有用户信息
     * /user/1      GET     查询根据id查询用户信息
     * /user        POST    添加用户信息
     * /user/1      DELETE  删除用户信息
     * /user/1      PUT     更新用户信息
     */

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUsers(){
        System.out.println("Get all users");
        return "success";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable(value = "id") String id){
        System.out.println("Get: get user by id");
        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(String username, String password){
        System.out.println("Post: to add user info: "+username +"---" +password);
        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String modifyUsers(String username, String password){
        System.out.println("Put: to modify user info: "+username +"---" +password);
        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public String deleteUsers(String username, String password){
        System.out.println("Delete: to delete user info: "+username +"---" +password);
        return "success";
    }

}
