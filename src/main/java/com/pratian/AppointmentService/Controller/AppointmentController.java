package com.pratian.AppointmentService.Controller;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.pratian.AppointmentService.Entities.Appointment;
import com.pratian.AppointmentService.Entities.Test;
import com.pratian.AppointmentService.Entities.Vitals;
import com.pratian.AppointmentService.Exceptions.AppointmentNotFoundException;
import com.pratian.AppointmentService.Exceptions.VitalsNotFoundException;
import com.pratian.AppointmentService.Service.Impl.AppointmentServiceImpl;
import com.pratian.AppointmentService.Service.Impl.TestServiceImpl;
import com.pratian.AppointmentService.Entities.Comment;
import com.pratian.AppointmentService.Entities.Recommendation;
import com.pratian.AppointmentService.Service.CommentService;
import com.pratian.AppointmentService.Service.IAppointmentService;




@CrossOrigin(origins = "*")
@RestController
//@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "If_Match")
@RequestMapping("/appointment")
public class AppointmentController {
	@Autowired
	public AppointmentServiceImpl asl;
	
	@Autowired 
	public TestServiceImpl tst;
	
	@Autowired
	public IAppointmentService service;
	
	
	@PostMapping("/addApp")
	public ResponseEntity<?> addApp(@RequestBody Appointment appointment) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<Appointment>(asl.addAppointment(appointment), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
		return response;
		
	}

	@Autowired
	CommentService commentservice;
	
	@RequestMapping(value="/editcomment",method=RequestMethod.PUT)
	
	public void put(@RequestBody Comment comment)
	{
		commentservice.editComment(comment);
	}
	
	
	@PutMapping("/updateApp/{id}")
	public ResponseEntity<?> updateApp(@RequestBody Test test[],@PathVariable(value="id")long id) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<Appointment>(asl.updateAppointment(test, id), HttpStatus.OK);
		} 
		catch (AppointmentNotFoundException e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return response;
		
		
		
	}
	@GetMapping("/getAllTestForAppointment/{id}")
	public ResponseEntity<?> getTestsforAppointment(@PathVariable(value="id")long id) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<Appointment>(asl.getTestsForAppointment(id), HttpStatus.OK);
		} 
		catch (AppointmentNotFoundException e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return response;
		 
		
	}
	@DeleteMapping("/deleteTests/{id},{test_id}")
	public ResponseEntity<?> deleteTestsfoAppointment(@PathVariable(value="id")long id,
			@PathVariable(value="test_id")long test_id) {
		ResponseEntity<?> response = null;
		try {
			asl.deleteTestsfoAppointment(id,test_id);
			response = new ResponseEntity<Appointment>( HttpStatus.OK);
		} 
		catch (AppointmentNotFoundException e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return response;
		
	}
	@RequestMapping(value="/getcomment/{id}",method =RequestMethod.GET)
	public Comment getById(@PathVariable(value="id")long id)
	{
		return commentservice.getComment(id);
	}	
	
	@RequestMapping(value = "/appoint/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateRecommendation(@RequestBody Recommendation rec[],
			@PathVariable(value = "id") long id) throws AppointmentNotFoundException {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<Appointment>(asl.updateRecommendationAppo(rec, id), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		return response;
	}
	@RequestMapping(value = "/appoint/{appointmentId}", method = RequestMethod.GET)
	public ResponseEntity<?> getAppointment(@PathVariable(value = "appointmentId") long appointmentId) {
		ResponseEntity<?> response = null;

		try {
			response = new ResponseEntity<>(asl.getAllAppointment(appointmentId), HttpStatus.OK);
			
		} 
		catch (AppointmentNotFoundException e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		return response;

	}

	@RequestMapping(value = "/appoint/{id},{recommendationId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteaAppointmnet(@PathVariable(value = "id") long id,
			@PathVariable(value = "recommendationId") long recommendationId) throws AppointmentNotFoundException {
		try {

			asl.deleteRecommendationAppointment(id, recommendationId);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}
	
	
	
	
	/**
	 * Method to handle API request for accepted appointments
	 * 
	 * @param accepted
	 * @return
	 */

	@RequestMapping(value = "api/acceptedAppointments", method = RequestMethod.GET)
	public  int getacceptedAppointments() {
		int count = asl.getAcceptedAppointments();
//		HttpStatus returnStatus = !appointments.isEmpty() ? HttpStatus.OK : HttpStatus.CONFLICT;
		return count;
	}

	/**
	 * Method to handle API request for total appointments
	 * 
	 * @param total
	 * @return
	 */
	@RequestMapping(value = "api/totalAppointments", method = RequestMethod.GET)
	public  int getTotalAppointments() {
		int count = asl.gettotalAppointments();
//		HttpStatus returnStatus = !appointments.isEmpty() ? HttpStatus.OK : HttpStatus.CONFLICT;
		return count;
	}
	/**
	 * Method to handle API request for cancelled appointments
	 * 
	 * @param cancelled
	 * @return 
	 * @return
	 */

	@RequestMapping(value = "api/cancelledAppointments", method = RequestMethod.GET)
	public  int getCancelledAppointments() {
		int count = asl.getCancelledAppointments();
//		HttpStatus returnStatus = !appointments.isEmpty() ? HttpStatus.OK : HttpStatus.CONFLICT;
		return count;
	}

	
	
	@RequestMapping(value = "api/allAppointments", method = RequestMethod.GET)
	public List<Appointment> getallAppointments() {
	List<Appointment> appointments =asl.getallAppointments();
//	HttpStatus returnStatus = !appointments.isEmpty() ? HttpStatus.OK : HttpStatus.CONFLICT;
	while(appointments.size()>8) { appointments.remove(appointments.size()-1); }
	return appointments;

	}
	@RequestMapping(value = "api/getfilterconfirmedAppointments", method = RequestMethod.GET)
	public List<Appointment> getfilterconfirmedAppointments() {
	List<Appointment> appointments =asl.getfilterconfirmedAppointments();
//	HttpStatus returnStatus = !appointments.isEmpty() ? HttpStatus.OK : HttpStatus.CONFLICT;
	while(appointments.size()>8) { appointments.remove(appointments.size()-1); }
	return appointments;

	}
	@RequestMapping(value = "api/getfiltercancelledAppointments", method = RequestMethod.GET)
	public List<Appointment> getfiltercancelledAppointments() {
	List<Appointment> appointments =asl.getfiltercancelledAppointments();
//	HttpStatus returnStatus = !appointments.isEmpty() ? HttpStatus.OK : HttpStatus.CONFLICT;
	while(appointments.size()>8) { appointments.remove(appointments.size()-1); }
	return appointments;

	}
	@RequestMapping(value = "api/getfilterclosedAppointments", method = RequestMethod.GET)
	public List<Appointment> getfilterclosedAppointments() {
	List<Appointment> appointments =asl.getfilterclosedAppointments();
//	HttpStatus returnStatus = !appointments.isEmpty() ? HttpStatus.OK : HttpStatus.CONFLICT;
	while(appointments.size()>8) { appointments.remove(appointments.size()-1); }
	return appointments;

	}
	

	//method to get vitals by appointment id
	
	@RequestMapping(value="/get/{id}",method = RequestMethod.GET)
	public Vitals getvitals(@PathVariable(value = "id") Long id) throws AppointmentNotFoundException
	{
		return asl.getVitalsbyAppoinmentId(id);
		
	}
	
	
	
	
	//edit or save vitals by appointment id
	@PutMapping("/savevital/{id}")
	public Vitals editvital(@PathVariable(value = "id") Long id, @RequestBody Vitals vital) throws VitalsNotFoundException, AppointmentNotFoundException
	{
		return asl.editVitals(vital,id);
		
		
	}
	
	@RequestMapping(value = "api/pending", method = RequestMethod.GET)
		public List<Appointment> getpendingAppointments() {
		List<Appointment> appointments =asl.getpendingAppointments();
//		HttpStatus returnStatus = !appointments.isEmpty() ? HttpStatus.OK : HttpStatus.CONFLICT;
		while(appointments.size()>8) { appointments.remove(appointments.size()-1); }
		return appointments;
		}

		@PutMapping(value = "api/updateappointment/{id},{status}")
	    public ResponseEntity<?> updateAppointment(
	            @PathVariable(value = "id") long id,@PathVariable(value="status") String status)  {
	        ResponseEntity<?> response = null;
	        System.out.println(status);
	        response = new ResponseEntity<Appointment>(service.updateAppointmnet(id,status), HttpStatus.OK);
	        
	 

	        return response;
	    }
		@RequestMapping(value = "api/appointment/{id}", method = RequestMethod.DELETE)
	    public void deleteaAppointmnet(@PathVariable(value = "id") long id) {
	 
	            service.cancelAppointment(id);
	            
	            

	 

	    }

	
	
	
	
}
	  



