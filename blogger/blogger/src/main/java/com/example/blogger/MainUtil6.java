package com.example.blogger;

import com.example.blogger.payload.PostDto;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainUtil6 {
    public static void main(String[] args) {
        List<Employee2> data = Arrays.asList(
                new Employee2("satyam", 30000),
                new Employee2("kashmir", 10000),
                new Employee2("dusan", 30000)

        );


        Map<Double, List<Employee2>> groups = data.stream().collect(Collectors.groupingBy(Employee2::getSalary));
        System.out.println(groups);

        for (Map.Entry<Double, List<Employee2>> entry : groups.entrySet()
        ) {
            double salary = entry.getKey();
            List<Employee2> employee2List = entry.getValue();
            System.out.println("Employee with salary" + salary + ":");
            for (Employee2 employee : employee2List
            ) {
                System.out.println("\t" + employee.getName());

            }


            }

        }
    }


