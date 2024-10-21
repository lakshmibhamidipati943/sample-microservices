package com.springboot.department_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.department_service.entity.Department;
import com.springboot.department_service.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		log.info("Inside saveDepartment() of DepartmentService");
		return departmentRepository.save(department);
	}

	@Override
	public Department findDepartmentById(Long departmentId) {
		// TODO Auto-generated method stub
		log.info("Inside findDepartmentById() of DepartmentService");
		return departmentRepository.findByDepartmentId(departmentId);
	}

}
