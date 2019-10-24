package com.helpdesk.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.helpdesk.ticket.dto.UserDTO;
import com.helpdesk.ticket.entities.Role;
import com.helpdesk.ticket.entities.Users;
import com.helpdesk.ticket.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/rays")
public class LoginController {

	@Autowired
	UserService userService;
	
	 @RequestMapping(path = "/check-login", method = RequestMethod.POST) 
	 public ResponseEntity<Object> checkLogin(@RequestBody UserDTO user) {
			
		 if(user != null) {
			 if(user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
				 user.setToken("qLGJXpqJiN-17MrH9eXjeJqRPBVdvLwumkfj54iRp9HHPkOFPfBBRz84Bcw0UNL6yJy.xD24HQj3Gr-XfC42q4k8YLreehZIJn-ed5DhS9auGjvGGMYNA6ePdxXl59ak");
				 return new ResponseEntity<>(user, HttpStatus.OK); 
			 }	
		 }
		 
		 return new ResponseEntity<>("Failure", HttpStatus.UNPROCESSABLE_ENTITY);
		 
	 }	 
	 
	 
	 @RequestMapping(path = "/testing", method = RequestMethod.GET) 
	 public ResponseEntity<String> testing() {
			Users user = new Users();
			user.setUsername("admin");
			user.setPassword("admin");
			user.setEmail("admin@xyz.com");
			user.setRole(Role.ADMIN);
			userService.create(user);
		 return new ResponseEntity<String>("Success", HttpStatus.OK);
		 
	 }	 
	 

	 @RequestMapping(path = "/test", method = RequestMethod.GET) 
	 public ResponseEntity<String> test() {
		 return new ResponseEntity<String>("Success", HttpStatus.OK); 
	 }	 
	 
	 
	 @RequestMapping(path = "/public", method = RequestMethod.GET) 
	 public ResponseEntity<String> publicUrl() {
		 return new ResponseEntity<String>("Success", HttpStatus.OK); 
	 }	 
	 
}

