package com.example.homeworkstream.controller;

import com.example.homeworkstream.domain.Employee;
import com.example.homeworkstream.service.ServiceDepartment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final ServiceDepartment serviceDepartment;

    public DepartmentController(ServiceDepartment serviceDepartment) {
        this.serviceDepartment = serviceDepartment;
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getDepartmentEmployees(@PathVariable int id) {
        return serviceDepartment.getEmployeeDepartment(id);
    }
    @GetMapping("/{id}/salary/sum")
    public double getDepartmentSalarySum(@PathVariable int id) {
        return serviceDepartment.sumSalaryDepartment(id);
    }
    @GetMapping("/{id}/salary/max")
    public double getDepartmentSalaryMax(@PathVariable int id) {
        return serviceDepartment.maxSalaryDepartment(id);
    }
    @GetMapping("/{id}/salary/min")
    public double getDepartmentSalaryMin(@PathVariable int id) {
        return serviceDepartment.minSalaryDepartment(id);
    }
    @GetMapping("/employees")
    public Map<Integer,List<Employee>> getAllEmployeeByDepartment() {
        return serviceDepartment.getEmployeeByDepartment();
    }

}
