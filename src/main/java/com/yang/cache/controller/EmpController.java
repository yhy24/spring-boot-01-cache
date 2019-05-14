package com.yang.cache.controller;

import com.yang.cache.bean.Employee;
import com.yang.cache.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yhy
 * @Date: 2018/9/29 15:20
 * @Version 1.0
 */
@RestController
public class EmpController {
    @Autowired
    EmpService empService;

    @RequestMapping("/get/{id}")
    public Employee getEmp(@PathVariable("id") Integer id) {
        Employee byId = empService.getById(id);
        return byId;
    }

    @RequestMapping("/update")
    public Employee updateEmp(Employee employee) {
        empService.updateEmp(employee);
        return employee;
    }

}
