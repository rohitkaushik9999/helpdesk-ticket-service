package com.helpdesk.ticket.service;

import java.util.Collection;

import com.helpdesk.ticket.entities.Users;

public interface UserService {

	public Users getUserById(long id);

    public Users getUserByEmail(String email);

    public Collection<Users> getAllUsers();

    public Users create(Users user);

    public Users aurthenticateUser(String username, String password);
}
