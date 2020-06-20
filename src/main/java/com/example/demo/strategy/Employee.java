package com.example.demo.strategy;

import lombok.Data;

/**
 * @author ：pp
 * @date ：Created in 2020/1/5 22:18
 */
@Data
public class Employee {
    private String name;
    private int age;
    private int salary;

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
