package com.example.homeworkstream.service;

import com.example.homeworkstream.domain.Employee;

import java.util.Map;

public interface ServiceEmployee {
    String remove(String lastName, String firstName);

    String find(String lastName, String firstName, int department, double salary);

    Map<String, Employee> getEmployeeBook();

    String add(String lastName, String firstName, int department, double salary);

}
