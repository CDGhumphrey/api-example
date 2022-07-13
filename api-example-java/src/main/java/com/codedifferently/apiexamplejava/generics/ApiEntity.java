package com.codedifferently.apiexamplejava.generics;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public abstract class ApiEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    public Long Id;
}
