package com.helpdesk.ticket.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.helpdesk.ticket.entities.Users;
import com.helpdesk.ticket.repositories.UserRepository;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService{

	@Autowired
	UserRepository userRepository;
	
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(userId);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()), user.getPassword(), getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
	
	@Override
	public Users getUserById(long id) {
	 return userRepository.findOneById(id);
	}
	
	@Override
	public Users getUserByEmail(String email) {
	 return userRepository.findOneByEmail(email);
	}
	
	@Override
	public Collection<Users> getAllUsers() {
	 return (Collection<Users>) userRepository.findAll();
	}
	
	@Override
	public Users create(Users user) {
	  return userRepository.save(user);
	}
	
	@Override
	public Users aurthenticateUser(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

}
