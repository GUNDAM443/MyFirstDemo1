package com.example.demo;

import com.example.demo.strategy.Employee;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamTest {
    List<Employee> list=Arrays.asList(
            new Employee("小米",18,3333),
            new Employee("小王",20,4444),
            new Employee("小李",50,8888),
            new Employee("老丁",30,7777)
    );

    
}
