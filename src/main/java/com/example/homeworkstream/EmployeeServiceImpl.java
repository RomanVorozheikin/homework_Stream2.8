package com.example.homeworkstream;

import com.example.homeworkstream.example.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements ServiceEmployee {
    private final Map<String, Employee> employeeBook = new HashMap<>();


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
    @Override
    public String printEmployeeBook() {
        StringBuilder builder = new StringBuilder(65 * employeeBook.size());

        for (Employee employee : employeeBook.values()) {
            builder.append(employee);
            builder.append('\n');
        }
        return builder.toString();
    }
    @Override
    public String printEmployeeByDepartment() {
        Map<Integer, List<Employee>> employeesByDepartment = employeeBook.values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        employeesByDepartment.forEach((department, empList) -> {
            System.out.println("Department " + department + ":");
            empList.forEach(System.out::println);
            System.out.println();
        });
        return employeesByDepartment.toString();
    }

    @Override
    public Employee maxSalaryDepartment(int department) {
        Optional<Employee> employeeWithMaxSalary = employeeBook.values().stream()
                .filter(e -> e.getDepartment() == department)
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));

                employeeWithMaxSalary.ifPresent(employee ->
                System.out.println("Сотрудник с максимальной зарплатой: " + employee));
        return employeeWithMaxSalary.orElseThrow(()->new RuntimeException("Сотрудник не найден"));
    }

    @Override
    public Employee minSalaryDepartment(int department) {
        Optional<Employee> employeeWithMinSalary = employeeBook.values().stream()
                .filter(e -> e.getDepartment() == department)
                .min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));

        employeeWithMinSalary.ifPresent(employee ->
                System.out.println("Сотрудник с минимальной зарплатой: " + employee));
        return employeeWithMinSalary.orElseThrow(()->new RuntimeException("Сотрудник не найден"));
    }

    @Override
    public List<Employee> printEmployeeDepartment(int department) {
        return employeeBook.values().stream()
                .filter(e->e.getDepartment()==department)
                .collect(Collectors.toList());
    }
}