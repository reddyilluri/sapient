package com.pratian.AppointmentService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pratian.AppointmentService.Entities.Prescriptions;
import com.pratian.AppointmentService.Exceptions.AppointmentNotFoundException;
import com.pratian.AppointmentService.Exceptions.PrescriptionServiceException;
import com.pratian.AppointmentService.Service.Impl.PrescriptionServiceIml;


@CrossOrigin(origins = "*")
@RestController
// @CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "If_Match")
@RequestMapping("/Prescriptions")
public class PrescriptionController {
	@Autowired
	private PrescriptionServiceIml prescriptionServiceIml;	
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> editMedicine(@PathVariable(value = "id") long id,
			@RequestBody Prescriptions pre) throws PrescriptionServiceException {
		
		ResponseEntity<?> responseEntity = null;

		try {
			responseEntity = new ResponseEntity<>(prescriptionServiceIml.editMedicine(id, pre), HttpStatus.OK);
		} catch (PrescriptionServiceException e) {

			responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return  responseEntity;
		
	}	

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteMedicine(@PathVariable(value = "id") long id) throws PrescriptionServiceException {
		ResponseEntity<?> responseEntity = null;

		try {
			prescriptionServiceIml.deletePrescription(id);
		} catch (PrescriptionServiceException e) {
			responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return responseEntity;
	}
	
	
	@RequestMapping(value = "/getone/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getOnePrescriprion(@PathVariable(value = "id") long id)
			throws PrescriptionServiceException {
		
		ResponseEntity<?> responseEntity = null;
		try {
			responseEntity = new ResponseEntity<>(prescriptionServiceIml.getOnePrescriprion(id), HttpStatus.OK);
		} catch (PrescriptionServiceException e) {

			responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return  responseEntity;	
		
	}
	
	@RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> addMedicinenew(@RequestBody Prescriptions pre,@PathVariable(value = "id") long id)throws PrescriptionServiceException, AppointmentNotFoundException { 
			
		ResponseEntity<?> responseEntity = null;

		try {
			responseEntity = new ResponseEntity<>(prescriptionServiceIml.addMedicine(pre,id), HttpStatus.OK);
			
		} catch (PrescriptionServiceException e) {

			responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return  responseEntity;
	}
	
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> viewAllPrescriptions(@PathVariable(value = "id") long id) throws AppointmentNotFoundException, PrescriptionServiceException {

		ResponseEntity<?> responseEntity = null;
		
		try {
			responseEntity = new ResponseEntity<>(prescriptionServiceIml.viewPrescriptionbyAppointmentId(id), HttpStatus.OK);
		} catch (PrescriptionServiceException e) {

			responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return  responseEntity;
	}

}
