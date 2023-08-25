package com.example.homeworkstream.service;

import com.example.homeworkstream.domain.Employee;

import java.util.List;
import java.util.Map;

public interface ServiceDepartment {
    List<Employee> getEmployeeDepartment(int department);

    Map<Integer, List<Employee>> getEmployeeByDepartment();

    double minSalaryDepartment(int department);

    double sumSalaryDepartment(int department);

    double maxSalaryDepartment(int department);
}
