package com.pratian.AppointmentService.Controller;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.pratian.AppointmentService.Entities.Vitals;
import com.pratian.AppointmentService.Exceptions.AppointmentNotFoundException;
import com.pratian.AppointmentService.Exceptions.VitalsNotFoundException;
import com.pratian.AppointmentService.Service.Impl.VitalsServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@CrossOrigin(origins ="https://localhost:4200")

@RestController
// @CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "If_Match")
@RequestMapping("/vitals")

public class VitalsController {
	
	
	@Autowired
	 private VitalsServiceImpl vitalsservice;
	
	

//	@RequestMapping(value="/getvitals",method = RequestMethod.GET)
//	public List<Vitals>getVitals()
//	{
//		
//		return vitalsservice.getVitals();
//		
//	}
	
	
	@GetMapping(value = "/getallvitals")
    @Operation(summary = "to get all vitals")
    public ResponseEntity<?> getallvitals(){
        ResponseEntity<?> response = null;
        try
        {
            response = new ResponseEntity<>(vitalsservice.getVitals(),HttpStatus.OK);
        }
        catch(VitalsNotFoundException e)
        {
            response = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        return response;

    }
	
	//get vitals by id
	@RequestMapping(value="/getvitals/{id}",method = RequestMethod.GET)
	public  ResponseEntity<?> getVitalsById(@PathVariable(value = "id" ) long id) 
			throws VitalsNotFoundException
	{
		ResponseEntity<?> responseEntity = null;
		
		try {
			responseEntity = new ResponseEntity<>( vitalsservice.getVitalsById(id), HttpStatus.OK);
		} catch ( VitalsNotFoundException e) {

			responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return  responseEntity;	
		
		//return vitalsservice.getVitalsById(Long.parseLong(vitalsId));
	}
	
//	//get vitals by id
//		@RequestMapping(value="/getvitals/{vitalsId}",method = RequestMethod.GET)
//		public  ResponseEntity<?> getVitalsById(@PathVariable String vitalsId) 
//				throws VitalsNotFoundException
//		{
//			ResponseEntity<?> responseEntity = null;
//			
//			try {
//				responseEntity = new ResponseEntity<>( vitalsservice.getVitalsById(Long.parseLong(vitalsId)), HttpStatus.OK);
//			} catch ( VitalsNotFoundException e) {
//
//				responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
//			}
//			return  responseEntity;	
//			//return vitalsservice.getVitalsById(Long.parseLong(vitalsId));
//		}
//		
		
	
	//Add or save vitals by vital id
	
	@RequestMapping(value="/savevitals" ,method = RequestMethod.POST)
	public ResponseEntity<?> saveVital(@RequestBody Vitals vital)
			throws AppointmentNotFoundException, VitalsNotFoundException
	
	{
		ResponseEntity<?> response = null;
		response = new ResponseEntity <Vitals>(vitalsservice.saveVital(vital), HttpStatus.OK);
		return response;
		
		
	}
	
	

	@RequestMapping(value="/updatevitals/{vitalsId}",method = RequestMethod.PUT)
	public Vitals readVital(@PathVariable(value = "id") Long id, @RequestBody Vitals vital) throws VitalsNotFoundException
	{
		return vitalsservice.updateVital(id, vital);
		
	}

}
