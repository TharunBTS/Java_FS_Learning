package com.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	
	@Query("select u from User u where u.email = ?1")
	User getUserByEmail(String email);
	
	@Query("select u from User u where u.fname like %?1")
	List<User> getUsersByStartsWith(String fname);
}
