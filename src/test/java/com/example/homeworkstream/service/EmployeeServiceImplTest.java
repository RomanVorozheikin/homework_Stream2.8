package com.example.homeworkstream.service;

import com.example.homeworkstream.domain.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
    private final EmployeeServiceImpl employeeService=new EmployeeServiceImpl();

    private final Employee employee1 = new Employee("Ivan", "Ivanov", 1, 100);

    @BeforeEach
    void setUp() {
        employeeService.add("Set", "Jorh", 1, 100.0);
        employeeService.add("Vova", "Suchkov", 1, 100);
    }
    @Test
    public void testAddNewEmployee() {
        String actual = employeeService.add("Jon", "Swim", 1, 100.0);
        assertEquals("Сотрудник добавлен",actual);
    }

    @Test
    public void testAddExistingEmployee() {
        String actual = employeeService.add("Set", "Jorh", 1, 100.0);
        assertEquals("Такой сотрудник уже есть",actual);
    }

    @Test
    public void removeEmployee() {
        String actual = employeeService.remove("Set", "Jorh");
        assertEquals("Сотрудник удален",actual);
    }
    @Test
    public void removeExistingEmployee_returnsErrorMessage() {
        String actual = employeeService.remove("Anna", "Janna");
        assertEquals("Такого сотрудника нет",actual);
    }

    @Test
    public void testFindEmployee() {
        employeeService.getEmployeeBook().put("IvanIvanov", employee1);
        assertEquals(employee1.toString(),employeeService.find("Ivan","Ivanov",1,100));
    }
    @Test
    public void testFindNonExistingEmployee() {
        assertEquals("Такого сотрудника нет",employeeService.find("Ivan","Ivanov",1,100));
    }

    @Test
    public void testGetEmployeeBook() {
        Map<String, Employee> expected = new HashMap<>();
        expected.put("VovaSuchkov", new Employee("Vova", "Suchkov", 1, 100));
        expected.put("SetJorh", new Employee("Set", "Jorh", 1, 100));

        Map<String, Employee> actual = employeeService.getEmployeeBook();

        assertEquals(expected,actual);
    }
}