package com.pratian.AppointmentService.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratian.AppointmentService.Entities.Appointment;
import com.pratian.AppointmentService.Entities.Prescriptions;
import com.pratian.AppointmentService.Exceptions.AppointmentNotFoundException;
import com.pratian.AppointmentService.Exceptions.PrescriptionServiceException;
import com.pratian.AppointmentService.Repository.IAppointmentRepo;
import com.pratian.AppointmentService.Repository.IPrescriptionRepo;
import com.pratian.AppointmentService.Service.IPrescriptionService;

/*PrescriptionService by pooja*/

@Service
public class PrescriptionServiceIml implements IPrescriptionService {
	@Autowired
	IPrescriptionRepo iPrescriptionRepo;
	@Autowired
	IAppointmentRepo iApprepo;
	
	// method for add Prescriptions
	@Override
	public Prescriptions addMedicine(Prescriptions pre, long id)
			throws PrescriptionServiceException, AppointmentNotFoundException {
		
		Appointment oldAppointment = iApprepo.findById(id)
				.orElseThrow(() -> new AppointmentNotFoundException("appointment not found"));
		
		if (iPrescriptionRepo.existsById(pre.getPrescriptionId()))
			throw new PrescriptionServiceException("Prescriptions for this id already exist");
		else {
//			iPrescriptionRepo.save(pre);
			
			oldAppointment.getPrescriptions().add(pre);			
			iApprepo.save(oldAppointment);	
			
			return (Prescriptions) iPrescriptionRepo;
		}
	}

	// getOne Prescriptions by PrescriptionsId

	@Override
	public Prescriptions getOnePrescriprion(long id) throws PrescriptionServiceException {

		return iPrescriptionRepo.findById(id).orElseThrow(() -> new PrescriptionServiceException(id));
	}

	// method for delete Prescriptions

	@Override
	public void deletePrescription(long prescriptionId) throws PrescriptionServiceException {

		if (iPrescriptionRepo.existsById(prescriptionId))
			iPrescriptionRepo.deleteById(prescriptionId);
		else
			throw new PrescriptionServiceException(prescriptionId);

	}

	// method for edit Prescriptions
	@Override
	public Prescriptions editMedicine(long id, Prescriptions pre) throws PrescriptionServiceException {

		Prescriptions oldPre = iPrescriptionRepo.findById(id).orElseThrow(() -> new PrescriptionServiceException(id));

		oldPre.setDescription(pre.getDescription());
		oldPre.setDuration(pre.getDuration());
		oldPre.setMedicineCycle(pre.getMedicineCycle());
		oldPre.setMedicineName(pre.getMedicineName());
		oldPre.setTake_With_Food(pre.isTake_With_Food());

		return iPrescriptionRepo.save(oldPre);
	}
	
	// getAll Prescriptions by AppointmentId
	@Override
	public List<Prescriptions> viewPrescriptionbyAppointmentId(long id) throws PrescriptionServiceException, AppointmentNotFoundException {
		Appointment oldAppointment = iApprepo.findById(id)
				.orElseThrow(() -> new AppointmentNotFoundException("appointment not found"));	
		List<Prescriptions> preList=oldAppointment.getPrescriptions();
		if(preList.size()<0)
			throw new PrescriptionServiceException("Prescriptions for this appointment id does not exist");
		
		return oldAppointment.getPrescriptions();
	}
	// end by pooja

}
