package com.example.demo.strategy;

/**
 * @author ：pp
 * @date ：Created in 2020/1/5 22:33
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {

       return employee.getAge() > 25;
    }
}
