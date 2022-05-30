package com.ha.forum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ha.forum.model.User;
import com.ha.forum.repository.UserRepository;
import com.ha.forum.service.IUserService;

@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User checkUsername(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password );
	}

}
