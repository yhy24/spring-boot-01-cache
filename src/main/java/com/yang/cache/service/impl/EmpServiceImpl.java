package com.yang.cache.service.impl;

import com.yang.cache.bean.Employee;
import com.yang.cache.mapper.EmployeeMapper;
import com.yang.cache.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author: yhy
 * @Date: 2018/9/29 15:17
 * @Version 1.0
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    @Cacheable(cacheNames = "emp",key = "#id")
    public Employee getById(Integer id) {
        System.out.println("查询:" + id + ":Emp");
        Employee byId = employeeMapper.getById(id);
        return byId;
    }

    @Override
    @CachePut(cacheNames = "emp",key = "#employee.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("upodate结果"+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }
}
