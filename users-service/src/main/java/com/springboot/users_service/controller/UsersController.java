package com.springboot.users_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.users_service.entity.Users;
import com.springboot.users_service.service.UsersService;
import com.springboot.users_service.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@PostMapping("/")
	public Users saveUsers(@RequestBody Users users) {
		log.info("Inside saveUsers() of UsersController");
		return usersService.saveUsers(users);
	}
	
	@GetMapping("/{id}")
	public ResponseTemplateVO getUsersWithDepartment(@PathVariable("id") Long usersId) {
		log.info("Inside getUsersWithDepartment() of UsersController");
		return usersService.getUsersWithDepartment(usersId);
	}
}
