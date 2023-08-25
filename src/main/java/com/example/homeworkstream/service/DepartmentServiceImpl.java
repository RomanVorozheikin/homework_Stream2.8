package com.example.homeworkstream.service;

import com.example.homeworkstream.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class DepartmentServiceImpl implements ServiceDepartment {
    private final ServiceEmployee serviceEmployee;

    public DepartmentServiceImpl(ServiceEmployee serviceEmployee) {
        this.serviceEmployee = serviceEmployee;
    }

    @Override
    public double maxSalaryDepartment(int department) {
        return serviceEmployee.getEmployeeBook().values().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToDouble(Employee::getSalary)
                .max()
                .orElseThrow(()->new RuntimeException("Сотрудник не найден!"));
    }
    @Override
    public double sumSalaryDepartment(int department) {
        return serviceEmployee.getEmployeeBook().values().stream()
                .filter(e->e.getDepartment()==department)
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    @Override
    public double minSalaryDepartment(int department) {
        return serviceEmployee.getEmployeeBook().values().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToDouble(Employee::getSalary)
                .min()
                .orElseThrow(()->new RuntimeException("Сотрудник не найден!"));
    }

    @Override
    public List<Employee> getEmployeeDepartment(int department) {
        return serviceEmployee.getEmployeeBook().values().stream()
                .filter(e->e.getDepartment()==department)
                .collect(Collectors.toList());
    }
    @Override
    public Map<Integer,List<Employee>> getEmployeeByDepartment() {
        return serviceEmployee.getEmployeeBook().values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
