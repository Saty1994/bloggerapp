package com.example.blogger;

import java.util.Arrays;
import java.util.List;

public class MainUtil5 {
    public static void main(String[] args) {
        List<Employee1> name = Arrays.asList(new Employee1(2,"satyam"),new Employee1(3,"puja"));
        Employee1 employee1 = name.stream().max(Employee1::compareTo).get();
        Employee1 employee2 = name.stream().min(Employee1::compareTo).get();

        System.out.println(employee1.getId());
        System.out.println(employee1.getName());
        System.out.println(employee2.getId());
        System.out.println(employee2.getName());


    }
}
