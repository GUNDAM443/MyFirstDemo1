package com.example.demo.mongoDemo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.awt.print.Book;
import java.io.Serializable;
import java.util.List;

@Document(collection = "student") //该实体类对应集合名称
@Data
public class Student implements Serializable {
    @Id
    private String id;
    private String name;
    private String address;
    private int sex;
    private List<Books> books;
    /**getter and setter**/
}
