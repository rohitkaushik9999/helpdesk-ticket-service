package com.helpdesk.ticket.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.helpdesk.ticket.entities.Users;

public interface UserRepository extends JpaRepository<Users,Long> ,JpaSpecificationExecutor<Users>{

	Users findOneByEmail(String email);
	
	Users findOneById(Long id);
	
	List<Users> findAll();
	
	Users findByUsernameAndPassword(String username, String password);
	
	Users findByUsername(String username);
}
