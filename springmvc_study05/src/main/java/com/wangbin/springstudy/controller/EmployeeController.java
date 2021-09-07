package com.wangbin.springstudy.controller;

import com.wangbin.springstudy.bean.Employee;
import com.wangbin.springstudy.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping(value = "/employee")
    private String getEmployees(Model model){
        model.addAttribute("employees",employeeDao.getEmployees());
        return "list";
    }

    @DeleteMapping(value = "/employee/{id}")
    private String deleteEmployee(@PathVariable Integer id) {
        employeeDao.delete(id);
        return "redirect:/employee";
    }

    @GetMapping(value = "/addEmp")
    private String fillEmployeeInfo(){
        return "employee";
    }

    @PostMapping(value = "/employee")
    private String addEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @GetMapping(value = "/employee/{id}")
    private String findEmployee(@PathVariable Integer id,Model model) {
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "employee1";
    }

    @PutMapping(value = "/employee")
    private String updateEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping("/toError")
    public String toError(){
        int demo = 5/0;
        return "success";
    }
}
