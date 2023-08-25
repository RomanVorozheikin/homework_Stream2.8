package com.example.homeworkstream.service;

import com.example.homeworkstream.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements ServiceEmployee {
    private final Map<String, Employee> employeeBook = new HashMap<>();

    @Override
    public Map<String, Employee> getEmployeeBook() {
        return employeeBook;
    }
    @Override
    public String add(String lastName, String firstName, int department, double salary) {
        String fullName = lastName + firstName;
        if (!employeeBook.containsKey(fullName)) {
            Employee employee = new Employee(lastName, firstName, department, salary);
            employeeBook.put(fullName, employee);
            return "Сотрудник добавлен";
        } else return "Такой сотрудник уже есть";
    }
    @Override
    public String remove(String lastName, String firstName) {
        String fullName = lastName + firstName;
        if (employeeBook.containsKey(fullName)) {
            employeeBook.remove(fullName);
            return "Сотрудник удален";
        } else {
            return "Такого сотрудника нет";
        }
    }
    @Override
    public String find(String lastName, String firstName, int department, double salary) {
        String fullName = lastName + firstName;
        if (employeeBook.containsKey(fullName)) {
            return employeeBook.get(fullName).toString();
        } else return "Такого сотрудника нет";
    }

}