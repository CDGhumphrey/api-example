package com.codedifferently.apiexamplejava.student;


import com.codedifferently.apiexamplejava.generics.ApiEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Student extends ApiEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    public Long Id;
    public String firstName;
    public String lastName;
    public int roomNumber;
    public int gradeLevel;
}
