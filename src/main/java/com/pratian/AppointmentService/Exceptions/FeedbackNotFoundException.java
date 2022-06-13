package com.pratian.AppointmentService.Exceptions;

public class FeedbackNotFoundException extends Exception{

	public FeedbackNotFoundException(long id) {
		super("patient doesn't provide any feedback");
		
	}

	public FeedbackNotFoundException(String message) {
		super(message);
		
	}

	
}
