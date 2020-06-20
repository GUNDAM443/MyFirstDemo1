package com.example.demo.mapper;


import com.example.demo.domain.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ：pp
 * @date ：Created in 2019/10/8 13:25
 */
@Mapper
public interface PersonMapper {

    //采用注解方式查询实体
    @Select("select id,name,age from person")
    public List<Person> selectList();

    @Select("select id,name,age from person where id = #{id}")
    public Person selectById(@Param("id") Integer id);

}
