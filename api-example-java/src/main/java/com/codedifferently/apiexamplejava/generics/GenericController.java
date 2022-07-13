package com.codedifferently.apiexamplejava.generics;

import com.codedifferently.apiexamplejava.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public abstract class GenericController<T extends ApiEntity> {
    private GenericService<T> service;

    @Autowired
    protected GenericController(GenericService<T> service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody T t){
        try{
            return new ResponseEntity<>(service.create(t), HttpStatus.CREATED);
        }
        catch(CreateException ex){
            return new ResponseEntity<>((Student) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        try{
            return new ResponseEntity<>(service.get(id), HttpStatus.OK);
        }
        catch(GetException ex){
            return new ResponseEntity<>((T) null, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(service.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, T t){
        try {
            return new ResponseEntity<>(service.update(id, t),HttpStatus.OK);
        }
        catch(UpdateException ex){
            return new ResponseEntity<>((T) null, HttpStatus.NOT_MODIFIED);

        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)  {
        try {
            service.delete(id);
        } catch (DeleteException e) {
            return new ResponseEntity<>((T)null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>((T)null,HttpStatus.OK);
    }

}
