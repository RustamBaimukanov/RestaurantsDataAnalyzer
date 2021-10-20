package com.project.restaurantsdataanalyzer.service;

import com.project.restaurantsdataanalyzer.entity.Restaurant;
import com.project.restaurantsdataanalyzer.entity.Test;
import com.project.restaurantsdataanalyzer.repository.RestaurantRepository;
import com.project.restaurantsdataanalyzer.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public void addRestaurant(Restaurant restaurant){
        restaurantRepository.save(restaurant);
    }

}
