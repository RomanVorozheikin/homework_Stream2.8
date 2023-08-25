package com.example.homeworkstream.controller;

import com.example.homeworkstream.service.ServiceEmployee;
import com.example.homeworkstream.domain.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    private final ServiceEmployee serviceEmployee;

    public EmployeeController(ServiceEmployee serviceEmployee) {
        this.serviceEmployee = serviceEmployee;
    }
//    /add?lastName=Ivan&firstName=Ivanov&department=1&salary=10000
    @GetMapping("/add")
    public String add(@RequestParam("lastName") String lastName,
                      @RequestParam("firstName") String firstName,
                      @RequestParam("department") int department,
                      @RequestParam ("salary") double salary) {
        return serviceEmployee.add(lastName, firstName, department, salary);
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
}
