package com.test.repositories;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.Appointment;
import com.test.entity.Doctor;


@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Integer> {

    List<Appointment> findByDoctor(Doctor doctor);

    List<Appointment> findByAppointmentDate(LocalDate date);
}
