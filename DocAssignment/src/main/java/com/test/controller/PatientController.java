package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Patient;
import com.test.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	
	@PostMapping("/add")
	public Patient addPatient(@RequestBody Patient patient)
	{
		return patientService.addPatient(patient);
	}
	@PutMapping("/update")
	public Patient updatePatient(@RequestBody Patient patient)
	{
		return patientService.updatePatientDetails(patient);
	}
	@DeleteMapping("/delete")
	public Patient deletePatient(@RequestBody Patient patient)
	{
		return patientService.removePatientDetails(patient);
	}
	@GetMapping("/get")
	public List<Patient> getPatient()
	{
		return patientService.getAllPatient();
	}

}
