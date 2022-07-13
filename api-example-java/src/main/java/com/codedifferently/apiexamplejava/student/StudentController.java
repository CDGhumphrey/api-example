package com.codedifferently.apiexamplejava.student;

import com.codedifferently.apiexamplejava.generics.GenericController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController extends GenericController<Student> {
    public StudentController(StudentService studentService) {
       super(studentService);
    }
}
