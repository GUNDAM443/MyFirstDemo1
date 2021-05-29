package com.example.demo.mongoDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Query:
 * 精准条件：Criteria.where(“key”).is(“条件”)
 * 模糊条件：Criteria.where(“key”).regex(“条件”)
 * 判断大小：gt:大于 lt:小于 gte:大于等等 lte:小于等于
 * 或条件：new Criteria().orOperator(“条件”)
 * 与条件：new Criteria().andOperator(“条件”)//仅能有一个
 * 封装条件：query.addCriteria(criteria)
 * 分页：Pageable mypage = PageRequest.of(nowPage-1,10); //Springboot 2.x 10为每页10个
 * 	//Pageable mypage = new PageRequest(page-1,10); //Springboot 1.x 10为每页10个
 * 	query.with(mypage);
 * 排序：query.with(Sort.by(Sort.Order.desc("creatTime")));
 * 	query.with(Sort.by(Sort.Order.asc("creatTime")));
 * Tips:进行日期查询时只需将JAVA中得到的日期作为条件即可，而不用像其他教程中所说的转换后在查询。
 * 具体原因作为小白，我也不是很清楚。但是查询出的结果确实准确，按其他教程来程序并不能得到结果。
 */

@Service
public class StudentService {
    private MongoTemplate mtl;

    @Autowired
    public StudentService(MongoTemplate mtl) {
        this.mtl = mtl;
    }

    //C(增)
    //单个增
    public void saveStudent(Student student){
        mtl.save(student); //mtl.insert(student);也可以
        //若新增数据的主键已存在：save会对存在数据更新、insert不会保存
    }
    //批量增
    public void saveStudents(List<Student> studentlist){
        mtl.insert(studentlist);
        //若新增数据的主键已经存在，则会抛异常提示主键重复，不保存当前数据。
    }

    //U(改)
    public void updateStudent(Student student){
        mtl.save(student);
    }

    //R(查)
    //查询所有
    public List<Student> findAllStudent(){
        return mtl.findAll(Student.class);
    }
    //根据ID查询
    public Student findStudentById(String id){
        return mtl.findById(id,Student.class);
    }
    //根据姓名准确查询
    public List<Student> findStudentByName(String name){
        Query query = new Query(Criteria.where("name").is(name));
        return mtl.find(query, Student.class);
    }
    //根据地址模糊查询
    public List<Student> findStudentByAddress(String address){
        Pattern pattern=Pattern.compile("^.*"+address+".*$", Pattern.CASE_INSENSITIVE);
        Query query = new Query(Criteria.where("name").regex(pattern));
        return mtl.find(query, Student.class);
    }
    //多条件查询
    public List<Student> findMaleStudentByName(String name){
        Query query = new Query(new Criteria().andOperator(Criteria.where("name").is(name), Criteria.where("sex").is(0)));
        //所给例为与条件、若为或条件，将andOperator改为orOperator
        return mtl.find(query, Student.class);
    }
    //分页查询
    public List<Student> findStudentByNameWithPage(String name, int nowPage){
        Query query = new Query(Criteria.where("name").is(name));
        Pageable mypage = PageRequest.of(nowPage-1,10); //Springboot 2.x 10为每页10个
        //Pageable mypage = new PageRequest(page-1,10); //Springboot 1.x 10为每页10个
        query.with(mypage);
        return mtl.find(query,Student.class);
    }

    //D(删)
    public void deleteStudent(Student student){
        mtl.remove(student);
    }
}
