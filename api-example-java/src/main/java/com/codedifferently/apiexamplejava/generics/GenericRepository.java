package com.codedifferently.apiexamplejava.generics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GenericRepository<T extends ApiEntity> extends JpaRepository<T, Long> {
}
