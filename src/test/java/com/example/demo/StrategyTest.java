package com.example.demo;



import com.example.demo.strategy.Employee;
import com.example.demo.strategy.FilterEmployeeByAge;
import com.example.demo.strategy.MyPredicate;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：pp
 * @date ：Created in 2020/1/5 20:44
 */
/*
* 策略设计模式
* */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyTest {
    List<Employee> employees = Arrays.asList(
            new Employee("小米",18,3333),
            new Employee("小王",20,4444),
            new Employee("小李",50,8888),
            new Employee("老丁",30,7777)
    );



    //需求1:获取年龄大于25的员工
    @Test
    public void test01(){

        List<Employee> employees = filterEmployees(this.employees);
        employees.forEach(System.out::println);
    }

    public List<Employee> filterEmployees(List<Employee> list){
        ArrayList<Employee> emps = new ArrayList<>();

        for (Employee e:list){
            if (e.getAge()>25){
                emps.add(e);
            }
        }
        return emps;

    }

    //需求2:获取员工工资大于5000的员工
    @Test
    public void test02(){
        List<Employee> employees = filterEmployees2(this.employees);
        employees.forEach(System.out::println);
    }

    public List<Employee> filterEmployees2(List<Employee> list){
        ArrayList<Employee> emps = new ArrayList<>();

        for (Employee e:list){
            if (e.getSalary()>5000){
                emps.add(e);
            }
        }
        return emps;

    }

    //这种需求多的话   重复代码就多  可以考虑策略设计模式
    @Test
    public void test03(){
        List<Employee> employees = filterEmployee3(this.employees, new FilterEmployeeByAge());
        employees.forEach(System.out::println);
    }

    public List<Employee> filterEmployee3(List<Employee> list,MyPredicate<Employee> myPredicate){
        List<Employee> emps = new ArrayList<>();
        for (Employee e: list){
            if (myPredicate.test(e)){
                emps.add(e);
            }
        }
        return emps;
    }

    //1.8新特性
    @Test
    public void test04(){
        employees.stream()
                 .filter(e->e.getAge()>25)
                .limit(1)
                .forEach(System.out::println);

        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

        long count = employees.stream()
                .filter(e -> e.getName().equals("小明")).count();
        System.out.println("名字为小明的数量"+count);

        

    }

    @Test
    public void test05(){
        List<Employee> collect = employees.stream().filter(employee -> employee.getAge() > 25).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    String ids="1,2,3,4,7,8,,";
    @Test
    public void test06(){
        String[] split = ids.split(",");
        List<String> strings = Arrays.asList(split);
        List<Integer> collect = strings.stream().map(e -> Integer.parseInt(e)).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);
    }
}
