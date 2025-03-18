package com.test.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.Doctor;
import com.test.entity.Patient;
import com.test.repositories.IPatientRepository;
import com.test.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private IPatientRepository patientRepository;

    @Override
    public Patient addPatient(Patient bean) {
        return patientRepository.save(bean);
    }

    @Override
    public Patient updatePatientDetails(Patient bean) {
        Optional<Patient> optionalPatient = patientRepository.findById(bean.getPatientId());
        if (optionalPatient.isPresent()) {
            return patientRepository.save(bean);
        } else {
            throw new RuntimeException("Patient not found with id: " + bean.getPatientId());
        }
    }

    @Override
    public Patient removePatientDetails(Patient bean) {
        Optional<Patient> optionalPatient = patientRepository.findById(bean.getPatientId());
        if (optionalPatient.isPresent()) {
            patientRepository.delete(optionalPatient.get());
            return optionalPatient.get();
        } else {
            throw new RuntimeException("Patient not found with id: " + bean.getPatientId());
        }
    }

    @Override
    public Patient getPatient(Patient bean) {
        Optional<Patient> optionalPatient = patientRepository.findById(bean.getPatientId());
        return optionalPatient.orElseThrow(() -> new RuntimeException("Patient not found with id: " + bean.getPatientId()));
    }

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public List<Patient> getPatientListByDoctor(Doctor doctor) {
        return patientRepository.findByDoctor(doctor);
    }

//    @Override
//    public List<Patient> getPatientListByDate(LocalDate appdate) {
//        return patientRepository.findByAppointmentDate(appdate); // ✅ FIXED
//    }
    @Override
    public List<Patient> getPatientListByDate(LocalDate appdate) {
        return patientRepository.findByAppointmentDate(appdate); // ✅ FIXED
    }


}
