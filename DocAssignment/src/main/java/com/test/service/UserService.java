package com.test.service;

import com.test.entity.User;

public interface UserService {
	
	User validateUser(User user);
    User addUser(User user);
    User removeUser(User user);
    User updateUser(User user);
	
}
