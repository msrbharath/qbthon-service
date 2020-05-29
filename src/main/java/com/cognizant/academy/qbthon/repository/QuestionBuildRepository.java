package com.cognizant.academy.qbthon.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.cognizant.academy.qbthon.model.Questions;

@EnableScan
public interface QuestionBuildRepository extends CrudRepository<Questions, String>{

}
