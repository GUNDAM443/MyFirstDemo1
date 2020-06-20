package com.example.demo.service;

import com.example.demo.domain.Person;


import java.util.List;

/**
 * @author ：pp
 * @date ：Created in 2019/10/8 13:27
 */
public interface PersonService {

    public List<Person> selectList();

    public Person selectById(Integer id);
}
