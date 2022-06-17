package com.pratian.AppointmentService.Service;

import java.util.List;

import com.pratian.AppointmentService.Entities.Appointment;
import com.pratian.AppointmentService.Entities.Recommendation;
import com.pratian.AppointmentService.Entities.Test;
import com.pratian.AppointmentService.Entities.Vitals;
import com.pratian.AppointmentService.Exceptions.AppointmentNotFoundException;
import com.pratian.AppointmentService.Exceptions.VitalsNotFoundException;

public interface IAppointmentService {
	public Appointment addAppointment(Appointment appointment) throws AppointmentNotFoundException;
	public Appointment updateAppointment(Test test[], long id) throws AppointmentNotFoundException;
	public void deleteTestsfoAppointment(long id,long testId) throws AppointmentNotFoundException;
	public Appointment getTestsForAppointment(long id) throws AppointmentNotFoundException;
	
	Appointment updateRecommendationAppo(Recommendation rec[],long id)throws AppointmentNotFoundException;
	void deleteRecommendationAppointment(long id,long recommendationId)throws AppointmentNotFoundException;

	public Vitals getVitalsbyAppoinmentId(Long id) throws AppointmentNotFoundException;

	Vitals editVitals( Vitals vital,long vitalsId) throws VitalsNotFoundException, AppointmentNotFoundException;
	
	
	Appointment getAllAppointment(long appointmnetId)throws AppointmentNotFoundException ;

	public List<Appointment> getallAppointments();

	public int getAcceptedAppointments();

	public int getCancelledAppointments();
	public int gettotalAppointments();
	public List<Appointment> getfilterconfirmedAppointments();
	public List<Appointment> getfiltercancelledAppointments();
	public List<Appointment> getfilterclosedAppointments();

	List<Appointment> findAll();

	public Appointment updateAppointmnet(long id, String status);

	public void cancelAppointment(long id);
	public List<Appointment> getpendingAppointments();
	

	
	

}
