package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Doctor;
import com.test.service.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorservice;
	
	
	@PostMapping("/add")
	public Doctor addDoctor(@RequestBody Doctor doctor)
	{
		return doctorservice.addDoctor(doctor);
	}
	
	// Update Doctor Profile
    @PutMapping("/update")
    public Doctor updateDoctor(@RequestBody Doctor doctor) {
        return doctorservice.updateDoctorProfile(doctor);
    }

    // Delete Doctor
    @DeleteMapping("/delete/{doctorId}")
    public String deleteDoctor(@PathVariable Integer doctorId) {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(doctorId);
        doctorservice.removeDoctor(doctor);
        return "Doctor deleted successfully!";
    }

    // Get Doctor By Id
    @GetMapping("/get/{doctorId}")
    public Doctor getDoctor(@PathVariable Integer doctorId) {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(doctorId);
        return doctorservice.getDoctor(doctor);
    }

    // Get All Doctors
    @GetMapping("/list")
    public List<Doctor> getAllDoctors() {
        return doctorservice.getDoctorList();
    }

    // Get Doctors By Speciality
    @GetMapping("/speciality/{speciality}")
    public List<Doctor> getDoctorsBySpeciality(@PathVariable String speciality) {
        return doctorservice.getDoctorList(speciality);
    }

}
