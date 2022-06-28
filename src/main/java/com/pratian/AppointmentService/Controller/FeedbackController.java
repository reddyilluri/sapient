package com.pratian.AppointmentService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pratian.AppointmentService.Entities.Appointment;
import com.pratian.AppointmentService.Entities.Feedback;
import com.pratian.AppointmentService.Exceptions.AppointmentNotFoundException;
import com.pratian.AppointmentService.Exceptions.FeedbackNotFoundException;
import com.pratian.AppointmentService.Service.Impl.FeedbackServiceImpl;

@CrossOrigin(origins = "https://localhost:4200")
@RestController
// @CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "If_Match")
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	FeedbackServiceImpl service;

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getfeedback(@PathVariable(value = "id") Long id)
			throws FeedbackNotFoundException, AppointmentNotFoundException {

		ResponseEntity<?> responseEntity = null;

		try {
			responseEntity = new ResponseEntity<>(service.getFeedback(id), HttpStatus.OK);
		} catch (FeedbackNotFoundException e) {
			responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}

		return responseEntity;
	}
//
//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback pre) {
//
//		Feedback newfeedback = service.createFeedback(pre);
//		return new ResponseEntity<>(newfeedback, HttpStatus.CREATED);
//	}

}
