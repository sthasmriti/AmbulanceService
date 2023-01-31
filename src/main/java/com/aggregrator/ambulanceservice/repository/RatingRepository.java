package com.aggregrator.ambulanceservice.repository;

import com.aggregrator.ambulanceservice.model.Rating;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, Long> {
}
