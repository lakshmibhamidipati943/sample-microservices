package com.springboot.users_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.users_service.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long>{

	Users findByUsersId(Long usersId);
	

}
