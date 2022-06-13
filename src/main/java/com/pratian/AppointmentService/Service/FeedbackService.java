package com.pratian.AppointmentService.Service;



import org.springframework.stereotype.Service;

import com.pratian.AppointmentService.Entities.Feedback;
import com.pratian.AppointmentService.Exceptions.AppointmentNotFoundException;
import com.pratian.AppointmentService.Exceptions.FeedbackNotFoundException;
@Service
public interface FeedbackService {
	
	//public Feedback createFeedback(Feedback feedback);
	public Feedback getFeedback(Long id) throws FeedbackNotFoundException, AppointmentNotFoundException;
    //public Feedback addFeedback(Feedback feedback , Long id) throws AppointmentNotFoundException, FeedbackNotFoundException;

}
