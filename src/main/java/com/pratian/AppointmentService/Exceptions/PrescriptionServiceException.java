package com.pratian.AppointmentService.Exceptions;


public class PrescriptionServiceException extends Exception {
	

	public PrescriptionServiceException(String message) {
		super(message);
	}

	public PrescriptionServiceException(long prescriptionId) {
		super("Prescription for id " + prescriptionId + " does not exist.");
	}
}
