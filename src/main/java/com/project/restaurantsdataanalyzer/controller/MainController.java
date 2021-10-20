package com.project.restaurantsdataanalyzer.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.restaurantsdataanalyzer.entity.Restaurant;
import com.project.restaurantsdataanalyzer.entity.Test;
import com.project.restaurantsdataanalyzer.service.MainService;
import com.project.restaurantsdataanalyzer.service.RestaurantService;
import com.project.restaurantsdataanalyzer.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@RestController
public class MainController {
    @Autowired
    TestService testService;

    @Autowired
    MainService mainService;

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/")
    public String main(){
        List<Test> result = testService.findAll();
        System.out.println(result);
        return "Init test:"+result.get(0).getTest();
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant getRestaurant(@PathVariable String id) throws IOException {
        URL url = new URL("https://api.documenu.com/v2/restaurant/"+id+"?key="+mainService.getKEY());
        //Restaurant restaurant = new ObjectMapper().readValue(url, Restaurant.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(url);
        Restaurant restaurant = mapper.readValue(node.get("result").traverse(), Restaurant.class);
        restaurantService.addRestaurant(restaurant);
        return restaurant;
    }
}
