package com.cognizant.academy.qbthon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.academy.qbthon.dao.QBThonDao;
import com.cognizant.academy.qbthon.model.Skill;
import com.cognizant.academy.qbthon.repository.SkillsRepository;

@Service
public class SkillServiceImpl implements SkillService{

	@Autowired
	QBThonDao qbthonDao;
	
	@Autowired
	SkillsRepository skillRepository;

	@Override
	public List<Skill> getSkills() {
		return (List<Skill>) skillRepository.findAll();
	}

	@Override
	public void createSkillTable() {
		try {
			qbthonDao.createSkillTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addSkill(Skill skill) {
		skillRepository.save(skill);
		
	}

	@Override
	public void deleteSkill(String skillId) {
		Optional<Skill> skillToDelete = skillRepository.findById(skillId);
		if(skillToDelete.isPresent()) {
			skillRepository.delete(skillToDelete.get());
		}else {
			System.out.println("Nothing to delete");
		}
	}

}
