package com.springboot.users_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.users_service.entity.Users;
import com.springboot.users_service.repository.UsersRepository;
import com.springboot.users_service.vo.Department;
import com.springboot.users_service.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Users saveUsers(Users users) {
		// TODO Auto-generated method stub
		log.info("Inside saveUsers() of UsersService");
		return usersRepository.save(users);
	}

	@Override
	public ResponseTemplateVO getUsersWithDepartment(Long usersId) {
		// TODO Auto-generated method stub
		log.info("Inside getUsersWithDepartment() of UsersService");
		ResponseTemplateVO vo=new ResponseTemplateVO();
		Users users=usersRepository.findByUsersId(usersId);
		Department department= restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+users.getDepartmentId(), Department.class);
		vo.setUsers(users);
		vo.setDepartment(department);
		return vo;
	}

	
	
	
}
