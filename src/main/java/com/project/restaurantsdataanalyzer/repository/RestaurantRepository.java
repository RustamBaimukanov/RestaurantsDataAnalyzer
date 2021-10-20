package com.project.restaurantsdataanalyzer.repository;

import com.project.restaurantsdataanalyzer.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
}
