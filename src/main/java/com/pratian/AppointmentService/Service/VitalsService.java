package com.pratian.AppointmentService.Service;

import java.util.List;

import com.pratian.AppointmentService.Entities.Vitals;
import com.pratian.AppointmentService.Exceptions.VitalsNotFoundException;

public interface VitalsService {

	public List<Vitals>getVitals() throws VitalsNotFoundException;

	public Vitals getVitalsById(long vitalsId) throws VitalsNotFoundException;
	public Vitals saveVital(Vitals vital) throws VitalsNotFoundException;
	//public Vitals updateVital(Vitals vital);
	public Vitals updateVital( long vitalsID ,Vitals vital) throws VitalsNotFoundException;




}
