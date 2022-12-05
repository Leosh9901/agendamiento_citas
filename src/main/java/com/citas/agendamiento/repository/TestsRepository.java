package com.citas.agendamiento.repository;

import com.citas.agendamiento.entity.Tests;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestsRepository extends CrudRepository<Tests, Integer> {
}
