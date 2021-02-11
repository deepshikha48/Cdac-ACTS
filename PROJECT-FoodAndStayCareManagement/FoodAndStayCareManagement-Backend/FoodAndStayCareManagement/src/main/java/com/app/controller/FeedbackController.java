package com.app.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import com.app.pojos.Feedback;
import com.app.service.IFeedbackService;
import com.app.service.IUserService;

@RestController
@RequestMapping("/feedback")
@CrossOrigin("http://localhost:4200")
public class FeedbackController {

	@Autowired
	private IFeedbackService feedbackService;

	@Autowired
	private IUserService userService;

	public FeedbackController() {
		System.out.println("In ctor of " + getClass().getName());
	}

	@PostMapping("/{userId}")
	public ResponseEntity<?> addFeedback(@RequestBody Feedback feedback, @PathVariable int userId) {
		try {

			feedback.setUserId(userService.getUserById(userId).get());
			feedback.setDateTime(LocalDateTime.now());
			return new ResponseEntity<>(feedbackService.saveFeedback(feedback),HttpStatus.CREATED);

		} catch (RuntimeException e) {
			throw new HttpClientErrorException(HttpStatus.NOT_ACCEPTABLE);//406
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<?>  getAllFeedbackList(){
		List<Feedback> feedbacks=feedbackService.getAllFeedbacks();
		if(feedbacks.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
		}
		return new ResponseEntity<>(feedbacks,HttpStatus.OK);//200
	}

}
