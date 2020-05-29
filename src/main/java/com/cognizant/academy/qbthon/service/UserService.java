package com.cognizant.academy.qbthon.service;

import java.util.List;

import com.cognizant.academy.qbthon.model.Users;

public interface UserService {

	public List<Users> getUsers();

	public void createUsersTable();

	public void addUser(Users user);

	public void deleteUser(String userId);

}
