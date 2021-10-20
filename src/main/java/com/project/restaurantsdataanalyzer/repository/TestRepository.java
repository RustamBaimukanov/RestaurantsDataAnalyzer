package com.project.restaurantsdataanalyzer.repository;

import com.project.restaurantsdataanalyzer.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TestRepository extends JpaRepository<Test,Long> {
    List<Test> findAllByTest(String test);
}
