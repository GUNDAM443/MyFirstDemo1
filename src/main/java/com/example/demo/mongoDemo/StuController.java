package com.example.demo.mongoDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StuController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/save")
    public void save(@RequestBody Student student){
        studentService.saveStudent(student);
        System.out.println("666");
    }

    @RequestMapping("/findAllStudent")
    public List<Student> findAll(){
        List<Student> allStudent = studentService.findAllStudent();
        return allStudent;
    }
}
