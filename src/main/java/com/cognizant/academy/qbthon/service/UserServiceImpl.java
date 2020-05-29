package com.cognizant.academy.qbthon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.academy.qbthon.dao.QBThonDao;
import com.cognizant.academy.qbthon.model.Users;
import com.cognizant.academy.qbthon.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	QBThonDao qbthonDao;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<Users> getUsers() {
		return (List<Users>) userRepository.findAll();
	}

	@Override
	public void createUsersTable() {
		try {
			qbthonDao.createUsersTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addUser(Users user) {		
		userRepository.save(user);
	}

	@Override
	public void deleteUser(String userId) {
		Optional<Users> userToDelete = userRepository.findById(userId);
		if(userToDelete.isPresent()) {
			userRepository.delete(userToDelete.get());
		}else {
			System.out.println("Nothing to delete");
		}
	}

}
