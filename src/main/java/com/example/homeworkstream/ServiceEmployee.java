package com.example.homeworkstream;

import com.example.homeworkstream.example.Employee;

import java.util.List;

public interface ServiceEmployee {
    String remove(String lastName, String firstName);

    String find(String lastName, String firstName, int department, double salary);

    String printEmployeeBook();

    String printEmployeeByDepartment();

    List<Employee> printEmployeeDepartment(int department);

    Employee minSalaryDepartment(int department);

    String add(String lastName, String firstName, int department, double salary);

    Employee maxSalaryDepartment(int department);
}
