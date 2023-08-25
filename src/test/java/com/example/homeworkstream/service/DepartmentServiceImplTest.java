package com.example.homeworkstream.service;

import com.example.homeworkstream.domain.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private ServiceEmployee serviceEmployee;
    @InjectMocks
    private DepartmentServiceImpl departmentService;
    private Map<String, Employee> employeeBook;
    @BeforeEach
    public void setUp() {
        employeeBook = new HashMap<>();
        employeeBook.put("RomaVrzhh", new Employee("Roma", "Vrzhh", 1, 300));
        employeeBook.put("RaVhh", new Employee("Ra", "Vhh", 2, 1500));
        employeeBook.put("RV", new Employee("R", "V", 1, 1000));
    }

    @Test
    public void testMaxSalaryDepartment() {
        when(serviceEmployee.getEmployeeBook()).thenReturn(employeeBook);

        double actual = departmentService.maxSalaryDepartment(1);

        assertEquals(1000.0,actual);
        verify(serviceEmployee, times(1)).getEmployeeBook();
        assertThrows(RuntimeException.class, () -> departmentService.maxSalaryDepartment(3));
    }

    @Test
    public void testSumSalaryDepartment() {
        when(serviceEmployee.getEmployeeBook()).thenReturn(employeeBook);

        double actual = departmentService.sumSalaryDepartment(1);

        assertEquals(1300.0,actual);
        assertThrows(RuntimeException.class, () -> departmentService.minSalaryDepartment(3));
    }

    @Test
    public void testMinSalaryDepartment() {
        when(serviceEmployee.getEmployeeBook()).thenReturn(employeeBook);

        double actual = departmentService.minSalaryDepartment(1);

        assertEquals(300.0,actual);
        verify(serviceEmployee, times(1)).getEmployeeBook();
        assertThrows(RuntimeException.class, () -> departmentService.minSalaryDepartment(3));
    }

    @Test
    public void testGetEmployeeDepartment() {
        when(serviceEmployee.getEmployeeBook()).thenReturn(employeeBook);

        List<Employee> expected = new ArrayList<>();
        List<Employee> actual = departmentService.getEmployeeDepartment(1);
        expected.add(new Employee("Roma", "Vrzhh", 1, 300));
        expected.add(new Employee("R", "V", 1, 1000));

        assertEquals(expected,actual);
    }

    @Test
    void getEmployeeByDepartment() {
        Employee employee1 = new Employee("Jon", "Liv", 1, 100.0);
        Employee employee2 = new Employee("Annet", "Hary", 1, 1000.0);
        Employee employee3 = new Employee("Ron", "Uizly", 2, 50.0);

        Map<String, Employee> employeeMap = new HashMap<>();
        employeeMap.put("1", employee1);
        employeeMap.put("2", employee2);
        employeeMap.put("3", employee3);

        when(serviceEmployee.getEmployeeBook()).thenReturn(employeeMap);

        Map<Integer, List<Employee>> expected = new HashMap<>();
        expected.put(1, List.of(employee1, employee2));
        expected.put(2, List.of(employee3));

        Map<Integer, List<Employee>> actual = departmentService.getEmployeeByDepartment();

        verify(serviceEmployee, times(1)).getEmployeeBook();
        assertEquals(expected,actual);
    }
}