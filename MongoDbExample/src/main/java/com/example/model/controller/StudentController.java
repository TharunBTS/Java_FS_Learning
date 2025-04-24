package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Student;
import com.example.repository.StudentRepository;

@RestController
@RequestMapping(value = "/api")
public class StudentController {
	
	@Autowired
	private StudentRepository repo;
	
	
	@GetMapping("/get")
	public List<Student> getStudents()
	{
		return repo.findAll();
	}
	
	@PostMapping("/post")
	public Student postStudents(@RequestBody Student student)
	{
		return repo.save(student);
	}
	
	
	

}
