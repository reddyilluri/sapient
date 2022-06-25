package com.pratian.AppointmentService.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pratian.AppointmentService.Entities.DoctorDetails;
import com.pratian.AppointmentService.Repository.DoctorDetailsRepository;
import com.pratian.AppointmentService.Repository.IAppointmentRepo;
import com.pratian.AppointmentService.Service.DoctorDetailsService;

@Service
public class DoctorDetailsServiceImpl implements DoctorDetailsService {

	@Autowired
	DoctorDetailsRepository doctordetailsrepository;
	@Autowired
	IAppointmentRepo appointmentrepository;
	@Override
	public DoctorDetails getDoctorDetails(long id) {
		return appointmentrepository.getAppointmentById(id).getDoctordetails();
//		return doctordetailsrepository.getDoctorDetailsById(id);
	}
	
	
	
}
