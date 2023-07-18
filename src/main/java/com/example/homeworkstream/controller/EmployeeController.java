package com.example.homeworkstream.controller;

import com.example.homeworkstream.ServiceEmployee;
import com.example.homeworkstream.example.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class EmployeeController {
    private final ServiceEmployee serviceEmployee;

    public EmployeeController(ServiceEmployee serviceEmployee) {
        this.serviceEmployee = serviceEmployee;
    }

    @GetMapping(path = "/add")
    public String add(@RequestParam("lastName") String lastName,
                      @RequestParam("firstName") String firstName,
                      @RequestParam("department") int department,
                      @RequestParam ("salary") double salary) {
        return serviceEmployee.add(lastName, firstName, department, salary);
    }
    @GetMapping
    public String printEmployeeBook() {
        return serviceEmployee.printEmployeeBook();
    }
    @GetMapping("/remove")
    public String remove(@RequestParam("lastName") String lastName,
                         @RequestParam("firstName") String firstName) {
        return serviceEmployee.remove(lastName,firstName);
    }
    @GetMapping("/find")
    public String find(@RequestParam("lastName") String lastName,
                       @RequestParam("firstName") String firstName,
                       @RequestParam("department") int department,
                       @RequestParam("salary") double salary) {
        return serviceEmployee.find(lastName,firstName,department,salary);
    }

    @GetMapping(path = "/all")
    public List<Employee> printEmployeeDepartment(@RequestParam("departmentId") int departmentId) {
        return serviceEmployee.printEmployeeDepartment(departmentId);
    }
    @GetMapping(path = "/all-by-department")
    public String printEmployeeByDepartment() {
      return serviceEmployee.printEmployeeByDepartment();
    }
    @GetMapping(path = "/max-salary")
    public Employee maxSalaryDepartment(@RequestParam("departmentId") int departmentId) {
        return serviceEmployee.maxSalaryDepartment(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalaryDepartment(@RequestParam("departmentId") int departmentId) {
        return serviceEmployee.minSalaryDepartment(departmentId);
    }

}
