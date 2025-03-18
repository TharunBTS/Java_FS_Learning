package com.test.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.Appointment;
import com.test.entity.Doctor;
import com.test.repositories.IAppointmentRepository;
import com.test.service.AppointmentService;

@Service
public class AppointmentImpl implements AppointmentService {

    @Autowired
    private IAppointmentRepository repo;

    @Override
    public List<Appointment> getAllAppointments(Appointment appointment) {
        
        return repo.findAll();
    }

    @Override
    public Appointment getAppointment(int appointmentId) {
        Optional<Appointment> appointmentOpt = repo.findById(appointmentId);
        return appointmentOpt.orElse(null); 
    }

    @Override
    public Appointment addAppointment(Appointment app) {
        return repo.save(app);
    }

    @Override
    public Appointment deleteAppointment(int appointmentId) {
        Optional<Appointment> appointmentOpt = repo.findById(appointmentId);

        if (appointmentOpt.isPresent()) {
            Appointment appointment = appointmentOpt.get();
            repo.delete(appointment);
            return appointment;
        }

        return null; 
    }

    @Override
    public Appointment updateAppointment(Appointment app) {
        Optional<Appointment> appointmentOpt = repo.findById(app.getAppointmentId());

        if (appointmentOpt.isPresent()) {
            return repo.save(app);
        }

        return null; // Or throw exception
    }

    @Override
    public List<Appointment> getAppointments(Doctor doc) {
        return repo.findByDoctor(doc);
    }

    @Override
    public List<Appointment> getAppointments(LocalDate date) {
        return repo.findByAppointmentDate(date);
    }
}
