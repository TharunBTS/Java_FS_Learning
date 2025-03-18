package com.test.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.AvailabilityDates;
import com.test.entity.Doctor;
import com.test.repositories.IAvailabilityDatesRepository;
import com.test.repositories.IDoctorRepository;
import com.test.service.DoctorService;

@Service
public class DoctorImpl implements DoctorService {

    @Autowired
    private IDoctorRepository doctorRepository;

    @Autowired
    private IAvailabilityDatesRepository availabilityDatesRepository;

    @Override
    public Doctor addDoctor(Doctor bean) {
        return doctorRepository.save(bean);
    }

    @Override
    public Doctor updateDoctorProfile(Doctor bean) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(bean.getDoctorId());
        if (optionalDoctor.isPresent()) {
            return doctorRepository.save(bean);  // Save the updated doctor details
        } else {
            throw new RuntimeException("Doctor not found with id: " + bean.getDoctorId());
        }
    }

    @Override
    public AvailabilityDates addAvailability(AvailabilityDates bean) {
        return availabilityDatesRepository.save(bean);
    }

    @Override
    public AvailabilityDates updateAvailability(AvailabilityDates bean) {
        Optional<AvailabilityDates> optionalAvailability = availabilityDatesRepository.findById(bean.getaId());
        if (optionalAvailability.isPresent()) {
            return availabilityDatesRepository.save(bean);
        } else {
            throw new RuntimeException("Availability not found with id: " + bean.getaId());
        }
    }

    @Override
    public Doctor getDoctor(Doctor doc) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(doc.getDoctorId());
        return optionalDoctor.orElseThrow(() -> new RuntimeException("Doctor not found with id: " + doc.getDoctorId()));
    }

    @Override
    public Doctor removeDoctor(Doctor doc) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(doc.getDoctorId());
        if (optionalDoctor.isPresent()) {
            doctorRepository.delete(optionalDoctor.get());
            return optionalDoctor.get();
        } else {
            throw new RuntimeException("Doctor not found with id: " + doc.getDoctorId());
        }
    }

    @Override
    public List<Doctor> getDoctorList() {
        return doctorRepository.findAll();
    }

    @Override
    public List<Doctor> getDoctorList(String speciality) {
        return doctorRepository.findBySpeciality(speciality);
    }
}
