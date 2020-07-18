package com.cognizant.academy.qbthon.service;

import java.util.List;

import com.cognizant.academy.qbthon.model.Skill;


public interface SkillService {

	public List<Skill> getSkills();

	public void createSkillTable();

	public void addSkill(Skill skill);

	public void deleteSkill(String skillId);

}
