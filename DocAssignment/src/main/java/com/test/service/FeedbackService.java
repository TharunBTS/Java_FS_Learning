package com.test.service;

import java.util.List;

import com.test.entity.Doctor;
import com.test.entity.Feedback;

public interface FeedbackService {
	
	
	Feedback addFeedback(Feedback fbd);
    Feedback getFeedback(Feedback fbd);
    List<Feedback> getAllFeedbacks(Doctor doc);

}
