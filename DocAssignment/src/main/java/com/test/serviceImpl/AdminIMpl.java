package com.test.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.Admin;
import com.test.repositories.IAdminRepository;
import com.test.service.AdminService;



@Service
public class AdminIMpl implements AdminService{

	@Autowired
	private IAdminRepository repo;
	
	@Override
	public Admin addAdmin(Admin admin) {
		return repo.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		
		Optional<Admin> op = repo.findById(admin.getAdminId());
		if(op.isPresent())
		{
			return repo.save(op.get());
		}
		else {
            throw new RuntimeException("User not found with id: " + admin.getAdminId());
        }
	}

	@Override
	public Admin removeAdmin(Admin admin) {
		Optional<Admin> op = repo.findById(admin.getAdminId());
		if(op.isPresent())
		{
			repo.delete(op.get());
			return op.get();
		}
		else {
            throw new RuntimeException("User not found with id: " + admin.getAdminId());
		}}

	@Override
	public Admin viewAdmin(Admin admin) {
		Optional<Admin> optionalAdmin = repo.findById(admin.getAdminId());
	    
	    if (optionalAdmin.isPresent()) {
	        return optionalAdmin.get();
	    } else {
	        throw new RuntimeException("Admin not found with id: " + admin.getAdminId());
	    }
	}
	
	
	
	
}
