package com.test.Collections;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.text.DateFormatter;



public record Customer(
	int customerId,
    String customerName,
    String customerUsername,
    LocalDate  customerDOB,
    String customerEmail,
    String customerContactNumber,
    String customerAlternateNumber,
    String customerMailingAddress,
    String customerPermanentAddress,
    String customerNationality,
    String customerNominee,
    String customerMMID,
    String customerAadhar,
    String customerPANNumber,
    String customerAccountId
) 	
{
	public Customer(
			int customerId,
		    String customerName,
		    String customerUsername,
		    String cust_dob,
		    String customerEmail,
		    String customerContactNumber,
		    String customerAlternateNumber,
		    String customerMailingAddress,
		    String customerPermanentAddress,
		    String customerNationality,
		    String customerNominee,
		    String customerMMID,
		    String customerAadhar,
		    String customerPANNumber,
		    String customerAccountId)
		{
		    this(customerId,customerName, customerUsername,
		    		LocalDate .parse(cust_dob, DateTimeFormatter.ofPattern("yyyy-MM-dd")),
		         customerEmail, customerContactNumber, customerAlternateNumber,
		         customerMailingAddress, customerPermanentAddress, customerNationality,
		         customerNominee, customerMMID, customerAadhar, customerPANNumber, customerAccountId);
		}
	
	
}
