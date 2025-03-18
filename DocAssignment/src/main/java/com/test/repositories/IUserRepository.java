package com.test.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.User;


@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByUserNameAndPassword(String userName, String password);
	
}
