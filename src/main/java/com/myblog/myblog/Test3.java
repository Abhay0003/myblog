package com.myblog.myblog;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test3 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Abhay", 23 , "UP"),
                new Employee("Piyush", 30, "Jk"),
                new Employee("Sumit", 30 , "BH"),
                new Employee("Suman", 32 , "BH")
        );

        Map<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(e -> e.getCity()));
        for(List<Employee> emp : collect.values()){
            for(Employee x : emp){
                System.out.println(x.getName()+","+x.getCity()+","+x.getAge());
            }
        }
    }
}
