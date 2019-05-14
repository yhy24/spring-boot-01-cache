package com.yang.cache.service;

import com.yang.cache.bean.Employee;

/**
 * @Author: yhy
 * @Date: 2018/9/29 15:16
 * @Version 1.0
 */
public interface EmpService {
    public Employee getById(Integer id);
    public Employee updateEmp(Employee employee);
}
