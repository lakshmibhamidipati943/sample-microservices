package com.springboot.department_service.service;

import com.springboot.department_service.entity.Department;

public interface DepartmentService {

	Department saveDepartment(Department department);

	Department findDepartmentById(Long departmentId);

}
