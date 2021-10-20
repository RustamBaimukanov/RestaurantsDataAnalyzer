package com.project.restaurantsdataanalyzer.controller;

import com.project.restaurantsdataanalyzer.entity.Test;
import com.project.restaurantsdataanalyzer.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    TestService testService;

    @GetMapping("/")
    public String main(){
        List<Test> result = testService.findAll();
        System.out.println(result);
        return "Init test:"+result.get(0).getTest();
    }
}
