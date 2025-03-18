package com.test.service;

import java.time.LocalDate;
import java.util.List;

import com.test.entity.Doctor;
import com.test.entity.Patient;

public interface PatientService {
	
	Patient addPatient(Patient bean);
    Patient updatePatientDetails(Patient bean);
    Patient removePatientDetails(Patient bean);
    Patient getPatient(Patient bean);
    List<Patient> getAllPatient();
    List<Patient> getPatientListByDoctor(Doctor doctor);
    List<Patient> getPatientListByDate(LocalDate appointmentDate);

}
