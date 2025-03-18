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

import com.test.entity.Appointment;
import com.test.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	
	
	@Autowired
	private AppointmentService appointmentservice;
	
	@PostMapping("/add")
	public Appointment addAppointment(@RequestBody Appointment appointment)
	{
		return appointmentservice.addAppointment(appointment);
	}
	@DeleteMapping("/delete/{id}")
	public Appointment deleteAppointment(@PathVariable Integer id)
	{
		return appointmentservice.deleteAppointment(id);
	}
	@PutMapping("/update")
	public Appointment updateAppointment(@RequestBody Appointment appointment)
	{
		return appointmentservice.updateAppointment(appointment);
	}
	@GetMapping("/get")
	public List<Appointment> getAppointment(@RequestBody Appointment appointment)
	{
		return appointmentservice.getAllAppointments(appointment);
	}
	

}
