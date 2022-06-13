package com.pratian.AppointmentService.Service;

import java.util.List;

import com.pratian.AppointmentService.Entities.Prescriptions;
import com.pratian.AppointmentService.Exceptions.AppointmentNotFoundException;
import com.pratian.AppointmentService.Exceptions.PrescriptionServiceException;


public interface IPrescriptionService {
	
	//start by pooja
	
	Prescriptions editMedicine(long id, Prescriptions pre) throws PrescriptionServiceException;	
	void deletePrescription(long prescriptionId) throws PrescriptionServiceException;	
	Prescriptions getOnePrescriprion(long id) throws PrescriptionServiceException;
	Prescriptions addMedicine(Prescriptions pre, long id) throws PrescriptionServiceException, AppointmentNotFoundException;
	List<Prescriptions> viewPrescriptionbyAppointmentId(long id)
			throws PrescriptionServiceException, AppointmentNotFoundException;
	
	//end by pooja
	
}
