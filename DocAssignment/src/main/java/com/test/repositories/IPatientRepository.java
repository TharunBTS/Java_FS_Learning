package com.test.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.entity.Doctor;
import com.test.entity.Patient;



@Repository
public interface IPatientRepository extends JpaRepository<Patient, Integer>{

	List<Patient> findByDoctor(Doctor doctor);

	@Query("SELECT DISTINCT p FROM Patient p JOIN p.appointments a WHERE a.appointmentDate = :appdate")
    List<Patient> findByAppointmentDate(@Param("appdate") LocalDate appdate);

}
