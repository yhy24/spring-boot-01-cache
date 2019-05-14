package com.yang.cache.bean;

/**
 * @Author: yhy
 * @Date: 2018/9/28 16:45
 * @Version 1.0
 */
public class Department {
   private Integer id;
    private String departmentName;

    public Department() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
