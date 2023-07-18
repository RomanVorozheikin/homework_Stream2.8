package com.example.homeworkstream.example;

import java.util.Objects;

public class Employee {
    private final String lastName;
    private final String firstName;
    private final int department;
    private final double salary;

    public Employee(String lastName, String firstName, int department, double salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.department = department;
        this.salary = salary;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (department != employee.department) return false;
        if (Double.compare(employee.salary, salary) != 0) return false;
        if (!Objects.equals(lastName, employee.lastName)) return false;
        return Objects.equals(firstName, employee.firstName);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = lastName != null ? lastName.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + department;
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}
