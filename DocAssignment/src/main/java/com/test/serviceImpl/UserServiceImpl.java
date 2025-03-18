package com.test.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.User;
import com.test.repositories.IUserRepository;
import com.test.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private IUserRepository repo;
	
	@Override
	public User validateUser(User user) {
		Optional<User> optionalUser = repo.findByUserNameAndPassword(user.getUserName(), user.getPassword());

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new RuntimeException("Invalid username or password");
        }
	}

	@Override
	public User addUser(User user) {
		
		return repo.save(user);
	}

	@Override
	public User removeUser(User user) {
		Optional<User> op = repo.findById(user.getUserId());
		if(op.isPresent())
		{
			repo.delete(op.get());
			return op.get();
		}
		else {
            throw new RuntimeException("User not found with id: " + user.getUserId());
        }
		
	}

	@Override
	public User updateUser(User user) {
		Optional<User> op = repo.findById(user.getUserId());
		if(op.isPresent())
		{
			return repo.save(op.get());
		}
		else {
            throw new RuntimeException("User not found with id: " + user.getUserId());
        }
	}

}
