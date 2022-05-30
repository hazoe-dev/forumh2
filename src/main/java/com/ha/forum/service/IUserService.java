package com.ha.forum.service;

import com.ha.forum.model.User;

public interface IUserService {
	public User checkUsername(String username, String password);
}
