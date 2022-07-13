package com.codedifferently.apiexamplejava.student;

import com.codedifferently.apiexamplejava.generics.GenericServiceAbstr;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends GenericServiceAbstr<Student> implements StudentService {
    private StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository) {
        super(studentRepository);
        this.studentRepository = studentRepository;
    }
}
