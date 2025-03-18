package com.test.service;

import com.test.entity.Admin;

public interface AdminService {
	
	Admin addAdmin(Admin admin);
    Admin updateAdmin(Admin admin);
    Admin removeAdmin(Admin admin);
    Admin viewAdmin(Admin admin);
	
	
}
