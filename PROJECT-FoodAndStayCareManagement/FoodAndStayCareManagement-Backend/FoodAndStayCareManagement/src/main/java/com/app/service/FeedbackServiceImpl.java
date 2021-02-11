package com.app.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Feedback;
import com.app.repository.FeedbackRepository;
@Service
@Transactional
public class FeedbackServiceImpl implements IFeedbackService {
	
	@Autowired
	private FeedbackRepository feedbackRepo;

	@Override
	public Feedback saveFeedback(Feedback feedback) {
		
		return feedbackRepo.save(feedback);
	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		
		return feedbackRepo.findAll();
	}
	
	

}
