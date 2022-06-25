package com.pratian.AppointmentService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pratian.AppointmentService.Entities.DoctorDetails;
import com.pratian.AppointmentService.Entities.Recommendation;
import com.pratian.AppointmentService.Exceptions.DoctorNameNotFoundException;
import com.pratian.AppointmentService.Service.Impl.RecommendationServiceImpl;


@CrossOrigin(origins = "*")
@RestController
//@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "If_Match")
@RequestMapping("/recommendation")
public class RecommendationController {

	@Autowired
	RecommendationServiceImpl impl;

	/*
	 * method to handle API request for add doctor name into recommendation table
	 * 
	 * @RequestBody
	 * 
	 * @RequestMapping
	 */
	@RequestMapping(value = "/rec", method = RequestMethod.POST)
	public ResponseEntity<?> addRecommendation(@RequestBody Recommendation rec) {
		ResponseEntity<?> response = null;

		try {
			response = new ResponseEntity<Recommendation>(impl.addRecommendation(rec), HttpStatus.OK);
		}

		catch (DoctorNameNotFoundException e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}

		return response;
	}

	@RequestMapping(value = "/rec", method = RequestMethod.GET)
	public ResponseEntity<?> getAllRecommendation() {
		ResponseEntity<?> response = null;

		try {
			response = new ResponseEntity<>(impl.getAllRecommendation(), HttpStatus.OK);
		} 
		catch (DoctorNameNotFoundException e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		return response;
	}

	/*
	 * @RequestMapping(value = "/rec/{recommendationId}", method =
	 * RequestMethod.DELETE) public ResponseEntity<?>
	 * deleteRecommendation(@PathVariable(value = "recommendationId") long
	 * recommendationId) throws DoctorNameNotFoundException { try {
	 * 
	 * impl.removeRecommedation(recommendationId); return new
	 * ResponseEntity<>(HttpStatus.NO_CONTENT); } catch (Exception e) { return new
	 * ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); }
	 * 
	 * }
	 */

	@RequestMapping(value = "/rec/doctors", method = RequestMethod.GET)
	public ResponseEntity<?> getAllDoctorDetails() {
		ResponseEntity<?> response = null;

		try {
			response = new ResponseEntity<>(impl.getAllDoctors(), HttpStatus.OK);
		} 
		catch (DoctorNameNotFoundException e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		return response;
	}

}
