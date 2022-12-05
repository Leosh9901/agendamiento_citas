package com.citas.agendamiento.repository;

import com.citas.agendamiento.entity.Affiliate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Affiliate,Integer> {
}
