package com.cognizant.academy.qbthon.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.cognizant.academy.qbthon.model.Skill;

@EnableScan
public interface SkillsRepository extends CrudRepository<Skill, String>{

}
