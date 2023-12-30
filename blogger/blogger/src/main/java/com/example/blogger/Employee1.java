package com.example.blogger;

public class Employee1 implements Comparable<Employee1> {

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public Employee1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Employee1 o) {
        return this.id-o.id;
    }
}
