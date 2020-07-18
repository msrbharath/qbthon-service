package com.cognizant.academy.qbthon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.academy.qbthon.model.Skill;
import com.cognizant.academy.qbthon.service.SkillService;

@RestController
@RequestMapping("/api/skills")
public class SkillController {


	@Autowired
	SkillService skillService;
	
	@RequestMapping(value = "/", produces = {"application/json"}, method = RequestMethod.GET)
	public ResponseEntity<List<Skill>> getSkill() {
		return ResponseEntity.status(HttpStatus.OK).body(skillService.getSkills());
	}
	
	@RequestMapping(value = "/create", produces = {"application/json"}, method = RequestMethod.GET)
	public void createUsersTable() {
		skillService.createSkillTable();
		ResponseEntity.status(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", produces = {"application/json"}, method = RequestMethod.POST)
	public void addUser(@RequestBody Skill skill) {
		skillService.addSkill(skill);
		ResponseEntity.status(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{skillId}", produces = {"application/json"}, method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable String skillId) {
		skillService.deleteSkill(skillId);
		ResponseEntity.status(HttpStatus.OK);
	}
}
