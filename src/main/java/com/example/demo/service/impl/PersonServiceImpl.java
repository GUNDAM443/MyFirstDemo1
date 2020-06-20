package com.example.demo.service.impl;


import com.example.demo.domain.Person;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //service注解
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonMapper mapper;//引用对象mapper

    @Override
    public List<Person> selectList() {
        return mapper.selectList();
    }

    @Override
    public Person selectById(Integer id) {
        return mapper.selectById(id);
    }
}