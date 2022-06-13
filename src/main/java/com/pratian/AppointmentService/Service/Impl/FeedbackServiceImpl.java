package com.pratian.AppointmentService.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.pratian.AppointmentService.Entities.Appointment;
import com.pratian.AppointmentService.Entities.Feedback;
import com.pratian.AppointmentService.Exceptions.AppointmentNotFoundException;
import com.pratian.AppointmentService.Exceptions.FeedbackNotFoundException;
import com.pratian.AppointmentService.Repository.FeedbackRepository;
import com.pratian.AppointmentService.Repository.IAppointmentRepo;
import com.pratian.AppointmentService.Service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepository repo;
	@Autowired
	IAppointmentRepo iApprepo;

//	@Override
//	public Feedback createFeedback(Feedback feedback) {
//
//		return repo.saveAndFlush(feedback);
//	}

	@Override
	public Feedback getFeedback(Long id) throws FeedbackNotFoundException, AppointmentNotFoundException {
		System.out.println("appoinment id :" + id);
		Appointment oldAppointment = iApprepo.findById(id)
				.orElseThrow(() -> new AppointmentNotFoundException("appointment not found"));
		;
		System.out.println(" patient feedback :" + oldAppointment.getFeedback().getComment());
		return oldAppointment.getFeedback();
	}
//
//	@Override
//	public Feedback addFeedback(Feedback feedback, Long id)
//			throws AppointmentNotFoundException, FeedbackNotFoundException {
//		Appointment oldAppointment = iApprepo.findById(id)
//				.orElseThrow(() -> new AppointmentNotFoundException("appointment not found"));
//
//		if (repo.existsById(feedback.getId()))
//			throw new FeedbackNotFoundException("feedback for this id already exist");
//		else {
//			repo.save(feedback);
//			oldAppointment.setFeedback(feedback);
//			;
//			iApprepo.save(oldAppointment);
//			return (Feedback) repo;
//		}
//	}
}
