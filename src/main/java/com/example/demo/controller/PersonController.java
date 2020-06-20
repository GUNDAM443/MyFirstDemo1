package com.example.demo.controller;

import com.example.demo.domain.Person;
import com.example.demo.service.PersonService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author ：pp
 * @date ：Created in 2019/10/8 13:29
 */
@ResponseBody
@Controller
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping("selectlist")
    public ModelAndView selectList() {
        ModelAndView modelAndView=new ModelAndView("index.html");

        List<Person> list =personService.selectList();

        modelAndView.addObject("list",list);

        return modelAndView;
    }
    @RequestMapping("selectlist01")
    public List<Person> selectList01() {

        return personService.selectList();
    }

    @RequestMapping("selectById/{id}")
    public Object selectById(@PathVariable Integer id){
        return personService.selectById(id);
    }

}