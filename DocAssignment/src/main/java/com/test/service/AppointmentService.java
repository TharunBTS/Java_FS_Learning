package com.test.service;

import java.time.LocalDate;
import java.util.List;

import com.test.entity.Appointment;
import com.test.entity.Doctor;

public interface AppointmentService {
	
	List<Appointment> getAllAppointments(Appointment app);
    Appointment getAppointment(int appointmentId);
    Appointment addAppointment(Appointment app);
    Appointment deleteAppointment(int appointmentId);
    Appointment updateAppointment(Appointment app);
    List<Appointment> getAppointments(Doctor doc);
    List<Appointment> getAppointments(LocalDate date);

}
