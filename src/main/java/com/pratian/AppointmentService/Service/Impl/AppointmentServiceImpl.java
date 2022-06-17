package com.pratian.AppointmentService.Service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pratian.AppointmentService.Entities.Test;
import com.pratian.AppointmentService.Entities.Vitals;
import com.pratian.AppointmentService.Exceptions.AppointmentNotFoundException;
import com.pratian.AppointmentService.Exceptions.VitalsNotFoundException;
import com.pratian.AppointmentService.Repository.IAppointmentRepo;
import com.pratian.AppointmentService.Repository.TestRepo;
import com.pratian.AppointmentService.Repository.VitalsRepo;
import com.pratian.AppointmentService.Entities.Appointment;
import com.pratian.AppointmentService.Entities.Comment;
import com.pratian.AppointmentService.Entities.Prescriptions;
import com.pratian.AppointmentService.Entities.Recommendation;
import com.pratian.AppointmentService.Repository.IPrescriptionRepo;
import com.pratian.AppointmentService.Repository.RecommendationRepository;
import com.pratian.AppointmentService.Service.CommentService;
import com.pratian.AppointmentService.Service.IAppointmentService;

@Service
public class AppointmentServiceImpl implements IAppointmentService {
@Autowired
IAppointmentRepo appRepo;
@Autowired
TestRepo tRepo;

@Autowired
RecommendationRepository repo;


@Autowired
VitalsRepo vitalrepo;


	@Override
	public Appointment addAppointment(Appointment appointment) throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		List<Appointment> te=appRepo.
				findAll()
				.stream().
				filter(t->t.getTests().equals(appointment.getTests())).
				collect(Collectors.toList());
		if(te.size()>0)   {
			throw new AppointmentNotFoundException("Test is already present");
		}
		else {
			return appRepo.save(appointment);
		}
		
	}
	

	@Override
	public Appointment updateAppointment(Test test[], long id) throws AppointmentNotFoundException {
		Appointment t = appRepo.findById(id).get();
		List<Appointment> te=appRepo.
				findAll()
				.stream().
				filter(a->a.getTests().equals(test)).
				collect(Collectors.toList());
		if(te.size()>0)   {
			throw new AppointmentNotFoundException("Test is already present");
		}
		else {
			List<Test> getAllSelected=new ArrayList<Test>()	;
			for(int i=0;i<=test.length-1;i++) {
				getAllSelected.add(test[i]);

			}
				t.setTests(getAllSelected);
					return appRepo.save(t);
		
		}
	
	}

	@Override
	public Appointment getTestsForAppointment(long id) throws AppointmentNotFoundException {
		if(appRepo.getTestsforAppointment(id)==null) {
			throw new AppointmentNotFoundException("Appointment not found.");
		}else {
			return appRepo.getTestsforAppointment(id);

		}
	}

	@Override
	public void deleteTestsfoAppointment(long id,long testId) throws AppointmentNotFoundException {
		if(appRepo.getTestsforAppointment(id)==null) {
			throw new AppointmentNotFoundException("Appointment not found.");
		}else {
			Appointment t = appRepo.findById(id).get();
			Test test=tRepo.findById(testId).get();
			System.out.println(test.getTestName());
			t.getTests().remove(test);
			 appRepo.save(t);
		}
		
	}
	

	@Override
	public Appointment updateRecommendationAppo(Recommendation rec[],long id) throws AppointmentNotFoundException {

		Appointment appointment = appRepo.findById(id).get();
		
		
		Map<Long, Recommendation> recMap = new HashMap<Long, Recommendation>();
		
		for(Recommendation r : rec) {
			if(recMap.get(r.getDoctor().getId())==null) {
				recMap.put(r.getDoctor().getId(), r);
			}
		}
		
		List<Recommendation> recList = recMap.values().stream().collect(Collectors.toList());
		
			List<Recommendation> getAllRec=new ArrayList<Recommendation>()	;
			for(int i=0;i<=recList.size() -1;i++) {
				getAllRec.add(recList.get(i));

				 }
				appointment.setRecommendations(getAllRec);
					return appRepo.save(appointment);
		
		//}
	
	}

	@Override
	public void deleteRecommendationAppointment(long id,long recommendationId) throws AppointmentNotFoundException {
		
		if(appRepo.getAppointmentByIdForRecommendation(id)==null) {
			throw new AppointmentNotFoundException("Appointment not found.");
		}else {
			Appointment appointment = appRepo.findById(id).get();
			Recommendation rec=repo.findById(recommendationId).get();
			System.out.println(rec.getDoctor());
			appointment.getRecommendations().remove(rec);
			appRepo.save(appointment);
		}
	
		
	}
	
	

	//method to get vitals by appointment id
	public Vitals getVitalsbyAppoinmentId(Long id) throws AppointmentNotFoundException {
		
		//System.out.println("appoinment id:"+id);
		Appointment oldAppoinment = appRepo.findById(id).orElseThrow(() -> new AppointmentNotFoundException("appoinment not found"));
		
		//System.out.println("appoinment id:"+oldAppoinment.getId());
		
			return oldAppoinment.getVitals();
	}
	
	
	//method to edit and save vitals by appointment id
	public Vitals editVitals(Vitals vital,long id)  throws  VitalsNotFoundException, AppointmentNotFoundException  {
		Appointment oldAppoinment = appRepo.findById(id).orElseThrow(() -> new AppointmentNotFoundException("vital not found for that appointment"));
		
		Vitals  v = oldAppoinment.getVitals();
		v.setECG(vital.getECG());
		v.setDiabetes(vital.getDiabetes());
		v.setTemperature(vital.getTemperature());
		v.setRespiration_rate(vital.getRespiration_rate());
		return  vitalrepo.save(v);
		
		
	}
	
	

	@Override
	public Appointment getAllAppointment(long appointmnetId) throws AppointmentNotFoundException {
		//List<Recommendation> lst=new ArrayList<Recommendation>();
		if(appRepo.findById(appointmnetId)==null) { 
			  throw new AppointmentNotFoundException("Data not found"); 
			  } 
		  else {
			 
			  return appRepo.getAppointmentByIdForRecommendation(appointmnetId);
			  }
	}

//	@Override
//	public Appointment updateAppointment(Appointment appointment,long id) {
//		Appointment t = appRepo.findById(id).get();
////		List<Test> getAllSelected=new ArrayList<Test>();
////		getAllSelected.add(tRepo.getOne(t.getTest()));
////		appointment.setTest(getAllSelected);
//		List<Test> getAllSelected=new ArrayList<Test>();
//		System.out.println(t.getId()+""+appointment.getTests().get(0).getTestId());
//
//		for(Test tq:appointment.getTests()) {
//			getAllSelected.add(tq);
//			System.out.println(t.getId()+""+tq.getTestId());
//			t.setTests(getAllSelected);		
//
//			//appointment.setTest(getAllSelected);
//		}
//        return appRepo.save(t);
//	}


	@Override
	public List<Appointment> findAll(){
		return appRepo.findAll();
	}

	public int getAcceptedAppointments() {
		List<Appointment> appiAppointments =appRepo.findAll();
		ArrayList<Appointment> acceptedAppiAppointments = new ArrayList<Appointment>();
		for (Appointment appointment : appiAppointments) {
			if (appointment.getStatus().equalsIgnoreCase("Accepted") ) {
				acceptedAppiAppointments.add(appointment);
			}
		}
		return acceptedAppiAppointments.size();
	}
	@Override
	public int getCancelledAppointments() {
		List<Appointment> appiAppointments = appRepo.findAll();
		ArrayList<Appointment> cancelAppiAppointments = new ArrayList<Appointment>();
		for (Appointment appointment : appiAppointments) {
			if (appointment.getStatus().equalsIgnoreCase("Cancelled")) {
				cancelAppiAppointments.add(appointment);
			}
		}
		return cancelAppiAppointments.size();
	}

	@Override
	public int gettotalAppointments() {
		return appRepo.findAll().size();
		
	}

	@Override
	public List<Appointment> getallAppointments() {
		// TODO Auto-generated method stub
		return appRepo.findAll();
	}

	

	@Override
	public List<Appointment> getfilterconfirmedAppointments() {
		List<Appointment> appiAppointments = appRepo.findAll();
		ArrayList<Appointment>confirmedAppiAppointments = new ArrayList<Appointment>();
		for (Appointment appointment : appiAppointments) {
			if (appointment.getStatus().equalsIgnoreCase("accepted")) {
				confirmedAppiAppointments.add(appointment);
			}
		}
		return confirmedAppiAppointments;
	}

	@Override
	public List<Appointment> getfiltercancelledAppointments() {
		List<Appointment> appiAppointments = appRepo.findAll();
		ArrayList<Appointment> cancelAppiAppointments = new ArrayList<Appointment>();
		for (Appointment appointment : appiAppointments) {
			if (appointment.getStatus().equalsIgnoreCase("Cancelled")) {
				cancelAppiAppointments.add(appointment);
			}
		}
		return cancelAppiAppointments;
	}

	@Override
	public List<Appointment> getfilterclosedAppointments() {
		List<Appointment> appiAppointments = appRepo.findAll();
		ArrayList<Appointment> closedAppiAppointments = new ArrayList<Appointment>();
		for (Appointment appointment : appiAppointments) {
			if (appointment.getStatus().equalsIgnoreCase("Closed")) {
				closedAppiAppointments.add(appointment);
			}
		}
		return closedAppiAppointments;
	}

//	public List<Appointment> getfiltercancelledAppointments() {
//	 TODO Auto-generated method stub
//		return iaAppointmentRepo.findAll();
//	}
//	@Override
//	public List<Appointment> getfilteracceptedAppointments() {
//		 TODO Auto-generated method stub
//		return iaAppointmentRepo.findAll();
//	}

	public Appointment updateAppointmnet(long id, String status){
        Appointment myPatient= appRepo.findById(id).get();
       myPatient.setStatus (status);
    		   return appRepo.save(myPatient);
    }



	@Override
	public void cancelAppointment(long id) {
		// TODO Auto-generated method stub
		appRepo.deleteById(id);
	}
	@Override
	public List<Appointment> getpendingAppointments() {
		List<Appointment> appiAppointments = appRepo.findAll();
		ArrayList<Appointment> pendingAppiAppointments = new ArrayList<Appointment>();
		for (Appointment appointment : appiAppointments) {
			if (appointment.getStatus().equalsIgnoreCase("pending")) {
			pendingAppiAppointments.add(appointment);
			}
		}
		return pendingAppiAppointments;
	}
	
}

	
	

