package com.pratian.AppointmentService.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pratian.AppointmentService.Entities.NewAppointment;
import com.pratian.AppointmentService.Exceptions.AppointmentNotFoundException;
import com.pratian.AppointmentService.Repository.NewIAppointmentRepo;
import com.pratian.AppointmentService.Service.NewIAppointmentService;

@Service
public class NewAppointmentServiceImpl implements NewIAppointmentService {
	@Autowired
    private NewIAppointmentRepo appointmentRepo;

	@Override
	public NewAppointment AddAppointment(NewAppointment appointment) {
						// TODO Auto-generated method stub
		return appointmentRepo.save(appointment);
	}

	@Override
	public List<NewAppointment> getAppointmentAll() {
		// TODO Auto-generated method stub
		return appointmentRepo.getAppointmentAll();
	}
	

	@Override
	public NewAppointment getAppointmentById(long id) {
		// TODO Auto-generated method stub
		//return appointmentRepo.getAppointmentById(id);
		return appointmentRepo.findById(id).get();
	}

	/*@Override
	public Appointment getAppointmentById(long id) {
		// TODO Auto-generated method stub
		return appointmentRepo.getMobilePhoneById(id);
	}
	
	
//save appointment
	
	@Override
	public Appointment AddAppointment(Appointment appointment)throws AppointmentNotFoundException 
	{
		 
		if(appointmentRepo.existsById(appointment.getId()))
		{
			throw new AppointmentNotFoundException("Appointment already exist");
		}else
		{
			Appointment appointment2=appointmentRepo.save(appointment);
			return appointment2;
		}
			
		 
	}*/
	
	
	}

	

