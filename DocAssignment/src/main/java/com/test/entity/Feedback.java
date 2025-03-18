package com.test.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;



@Entity
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fbId;
	
	private int rating;
//	private Patient patient;
//	private Doctor doctor;
	private String feedbackComment;
	public int getFbId() {
		return fbId;
	}
	public void setFbId(int fbId) {
		this.fbId = fbId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
//	public Patient getPatient() {
//		return patient;
//	}
//	public void setPatient(Patient patient) {
//		this.patient = patient;
//	}
//	public Doctor getDoctor() {
//		return doctor;
//	}
//	public void setDoctor(Doctor doctor) {
//		this.doctor = doctor;
//	}
	public String getFeedbackComment() {
		return feedbackComment;
	}
	public void setFeedbackComment(String feedbackComment) {
		this.feedbackComment = feedbackComment;
	}
	@Override
	public String toString() {
		return "Feedback [fbId=" + fbId + ", rating=" + rating + ", patient=" + "patient" + ", doctor=" + "doctor"
				+ ", feedbackComment=" + feedbackComment + "]";
	}
	
	

}
