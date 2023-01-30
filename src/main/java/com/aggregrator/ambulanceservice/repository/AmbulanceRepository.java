package com.aggregrator.ambulanceservice.repository;

import com.aggregrator.ambulanceservice.model.Ambulance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmbulanceRepository extends CrudRepository<Ambulance,Long> {

}
