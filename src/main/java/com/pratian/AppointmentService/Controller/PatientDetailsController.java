package com.pratian.AppointmentService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pratian.AppointmentService.Entities.PatientDetails;
import com.pratian.AppointmentService.Service.PatientDetailsService;

@CrossOrigin(origins = "https://localhost:4200")
@RestController
// @CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "If_Match")
@RequestMapping(value="/appointment")

public class PatientDetailsController {
	@Autowired
	PatientDetailsService patientdetailsservice;
	
	
	@RequestMapping(value="/getpatient/{id}",method =RequestMethod.GET)
	public PatientDetails getById(@PathVariable(value="id")long id)
	{
		return patientdetailsservice.getPatientDetails(id);
	}

}
