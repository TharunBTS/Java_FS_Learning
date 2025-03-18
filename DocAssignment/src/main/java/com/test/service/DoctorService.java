package com.test.service;

import java.util.List;


import com.test.entity.AvailabilityDates;
import com.test.entity.Doctor;

public interface DoctorService {
	
	
	Doctor addDoctor(Doctor bean);
    Doctor updateDoctorProfile(Doctor bean);
    AvailabilityDates addAvailability(AvailabilityDates bean);
    AvailabilityDates updateAvailability(AvailabilityDates bean);
    Doctor getDoctor(Doctor doc);
    Doctor removeDoctor(Doctor doc);
    List<Doctor> getDoctorList();
    List<Doctor> getDoctorList(String speciality);
	
}
