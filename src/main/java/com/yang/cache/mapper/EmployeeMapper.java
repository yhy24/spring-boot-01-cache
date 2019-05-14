package com.yang.cache.mapper;

import com.yang.cache.bean.Employee;

/**
 * @Author: yhy
 * @Date: 2018/9/29 14:53
 * @Version 1.0
 */
public interface EmployeeMapper {
    public Employee getById(Integer id);

    public void updateEmp(Employee employee);

    public void deleteEmpById(Integer id);

    public void insertEmp(Employee employee);


}
