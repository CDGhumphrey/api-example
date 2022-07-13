package com.codedifferently.apiexamplejava.generics;

import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class GenericServiceAbstr<T extends ApiEntity> implements GenericService<T>{
    private GenericRepository<T>  genericRepository;

    public GenericServiceAbstr(GenericRepository<T> genericRepository) {
        this.genericRepository = genericRepository;
    }

    @Override
    public T create(T t) throws CreateException {
        try {
            return genericRepository.save(t);
        }
        catch (Exception e){
            throw new CreateException(e.getMessage(), t.getClass().getSimpleName());
        }
    }

    @Override
    public T get(Long id) throws GetException {
        T t = null;
        try {
            Optional<T> optional =genericRepository.findById(id);
            if(optional.isPresent()) {
                t = optional.get();
                return t;
            }
            else throw new Exception("Not found");
        }
        catch (Exception e){
            throw new GetException(e.getMessage(), t.getClass().getSimpleName());
        }
    }

    @Override
    public List<T> get() {
        return genericRepository.findAll();
    }

    @Override
    public T update(Long id, T t) throws UpdateException {
        if(genericRepository.findById(id).isPresent())
          return  genericRepository.save(t);
        else throw new UpdateException("Not found", t.getClass().getSimpleName());
    }

    @Override
    public void delete(Long id) throws DeleteException {
        T t = null;
        try {
            Optional<T> optional =genericRepository.findById(id);
            if(optional.isPresent()) {
                t = optional.get();
                genericRepository.delete(t);
            }
            else throw new Exception("Not found");
        }
        catch (Exception e){
            throw new DeleteException(e.getMessage(), t.getClass().getSimpleName());
        }
    }
}
