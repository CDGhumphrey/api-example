package com.codedifferently.apiexamplejava.generics;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenericService<T extends ApiEntity>  {
   T create(T student) throws CreateException;
   T get(Long id) throws GetException;

   List<T> get();

   T update(Long id, T t) throws UpdateException;
   void delete(Long id) throws DeleteException;
}
