package com.project.restaurantsdataanalyzer.service;

import com.project.restaurantsdataanalyzer.entity.Test;
import com.project.restaurantsdataanalyzer.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    @Autowired
    TestRepository testRepository;


    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public void addTest(Test test){
        testRepository.save(test);
    }

    public Optional<Test> findById(Long id){
        return testRepository.findById(id);
    }

    public List<Test> findAll(){
        return testRepository.findAll();
    }

    public List<Test> findByTest(String test){
        return testRepository.findAllByTest(test);
    }
}
