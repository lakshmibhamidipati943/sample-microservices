package com.springboot.users_service.service;

import com.springboot.users_service.entity.Users;
import com.springboot.users_service.vo.ResponseTemplateVO;

public interface UsersService {

	Users saveUsers(Users users);

	ResponseTemplateVO getUsersWithDepartment(Long usersId);

}
