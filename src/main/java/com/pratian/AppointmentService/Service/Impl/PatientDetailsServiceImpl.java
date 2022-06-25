package com.pratian.AppointmentService.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratian.AppointmentService.Entities.PatientDetails;
import com.pratian.AppointmentService.Repository.IAppointmentRepo;
import com.pratian.AppointmentService.Repository.PatientDetailsRepository;
import com.pratian.AppointmentService.Service.PatientDetailsService;

@Service
public class PatientDetailsServiceImpl implements PatientDetailsService {

	@Autowired
	 PatientDetailsRepository patientdetailsrepository;
	@Autowired
	IAppointmentRepo appointmentrepository;
	@Override
	public  PatientDetails getPatientDetails(long id) {
		return appointmentrepository.getAppointmentById(id).getPatientdetails();
	}
//	@Override
//	public  PatientDetails getPatientDetails(long id) {
//		return patientdetailsrepository.getPatientDetailsById(id);
//	}
//	
	
	
	
}
