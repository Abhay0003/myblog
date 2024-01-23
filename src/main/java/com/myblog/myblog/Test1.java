package com.myblog.myblog;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Test1 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Abhay", 23 , "UP"),
                new Employee("Piyush", 30, "Jk"),
                new Employee("Sumit", 35 , "BH"),
                new Employee("Suman", 32 , "BH")
        );

        List<Employee> emps = employees.stream()
                .filter(emp -> emp.getName().startsWith("A")).
                collect(Collectors.toList());

        for (Employee e : emps) {
            System.out.println(e.getName() + ", " + e.getCity() + ", " + e.getAge());
        }
    }
}