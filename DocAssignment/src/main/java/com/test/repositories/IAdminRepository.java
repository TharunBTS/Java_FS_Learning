package com.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.Admin;


@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer>{

}
