package com.test.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.Date;





@Entity
public class AvailabilityDates {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aId;
//	private Doctor doctor;
	private Date fromDate;
	private Date localDate;
	public int getaId() {
		return aId;
	}
//	public void setaId(int aId) {
//		this.aId = aId;
//	}
//	public Doctor getDoctor() {
//		return doctor;
//	}
//	public void setDoctor(Doctor doctor) {
//		this.doctor = doctor;
//	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getLocalDate() {
		return localDate;
	}
	public void setLocalDate(Date localDate) {
		this.localDate = localDate;
	}
	@Override
	public String toString() {
		return "AvailabilityDates [aId=" + aId + ", doctor=" + "doctor" + ", fromDate=" + fromDate + ", localDate="
				+ localDate + "]";
	}
	
	
	

}
