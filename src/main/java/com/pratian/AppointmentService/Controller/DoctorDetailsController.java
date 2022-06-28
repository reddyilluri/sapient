package com.pratian.AppointmentService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pratian.AppointmentService.Entities.DoctorDetails;
import com.pratian.AppointmentService.Service.DoctorDetailsService;


@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RestController
// @CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "If_Match")
@RequestMapping(value="/appointment")
public class DoctorDetailsController {
	@Autowired
	DoctorDetailsService doctordetailsservice;
	
	
	@RequestMapping(value="/getdoctor/{id}",method =RequestMethod.GET)
	public DoctorDetails getById(@PathVariable(value="id")long id)
	{
		return doctordetailsservice.getDoctorDetails(id);
	}

}
