package com.pratian.AppointmentService.Service;

import java.util.List;

import org.springframework.aop.ThrowsAdvice;

import com.pratian.AppointmentService.Entities.Appointment;
import com.pratian.AppointmentService.Entities.NewAppointment;

import com.pratian.AppointmentService.Exceptions.AppointmentNotFoundException;

public interface NewIAppointmentService {
	
	public NewAppointment AddAppointment(NewAppointment appointment) ;
	public List<NewAppointment> getAppointmentAll();
	public NewAppointment getAppointmentById(long id);
	

}

