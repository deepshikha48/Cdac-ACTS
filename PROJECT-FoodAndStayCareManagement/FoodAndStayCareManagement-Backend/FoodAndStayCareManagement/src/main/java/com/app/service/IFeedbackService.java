package com.app.service;

import java.util.List;

import com.app.pojos.Feedback;

public interface IFeedbackService {

	Feedback saveFeedback(Feedback feedback);
	
	List<Feedback>getAllFeedbacks();
}
