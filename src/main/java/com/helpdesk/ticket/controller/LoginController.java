package com.helpdesk.ticket.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.helpdesk.ticket.dto.User;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	
	 @RequestMapping(path = "/check-login", method = RequestMethod.POST) 
	 public ResponseEntity<Object> checkLogin(@RequestBody User user) {
			
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
			
		 return new ResponseEntity<String>("Success", HttpStatus.OK);
		 
	 }	 
}
