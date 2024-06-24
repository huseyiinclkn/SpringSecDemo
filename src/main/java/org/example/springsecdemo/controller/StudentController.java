package org.example.springsecdemo.controller;


import org.example.springsecdemo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> list  = new ArrayList<Student>(List.of(
            new Student(1,"Hüseyin","Java"),
            new Student(2,"Ömer","JS"),
            new Student(3,"Hasan","C#")
    ));

    @GetMapping("getStudent")
    public List<Student> getStudent() {
        return list;

    }
    @PostMapping("postStudent")
    public String postStudent(@RequestBody Student student) {

        list.add(student);
        return "Success";
    }

}
