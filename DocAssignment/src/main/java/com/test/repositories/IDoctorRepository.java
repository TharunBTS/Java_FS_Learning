package com.test.repositories;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.Doctor;


@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {



	List<Doctor> findBySpeciality(String speciality);

}
