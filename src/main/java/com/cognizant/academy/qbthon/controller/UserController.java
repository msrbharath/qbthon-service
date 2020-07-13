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

import com.cognizant.academy.qbthon.model.Users;
import com.cognizant.academy.qbthon.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {


	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/", produces = {"application/json"}, method = RequestMethod.GET)
	public ResponseEntity<List<Users>> getUsers() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
	}
	
	@RequestMapping(value = "/create", produces = {"application/json"}, method = RequestMethod.GET)
	public void createUsersTable() {
		userService.createUsersTable();
		ResponseEntity.status(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", produces = {"application/json"}, method = RequestMethod.POST)
	public void addUser(@RequestBody Users users) {
		userService.addUser(users);
		ResponseEntity.status(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{userId}", produces = {"application/json"}, method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable String userId) {
		userService.deleteUser(userId);
		ResponseEntity.status(HttpStatus.OK);
	}
}
