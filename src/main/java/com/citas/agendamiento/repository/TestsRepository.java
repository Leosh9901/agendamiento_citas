package com.citas.agendamiento.repository;

import com.citas.agendamiento.entity.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestsRepository extends CrudRepository<Test, Integer> {
}
