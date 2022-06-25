package com.pratian.AppointmentService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.pratian.AppointmentService.Entities.Test;
import com.pratian.AppointmentService.Exceptions.AppointmentNotFoundException;
import com.pratian.AppointmentService.Service.Impl.TestServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
@CrossOrigin(origins = "*")
@RestController
//@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "If_Match")
@RequestMapping("/test")
public class TestController {
	@Autowired
	TestServiceImpl testService;
	
	/*
	 * Method to add test
	 * throws
	 */
	
	@PostMapping("/addtests")
	@Operation(summary = "To add the test")
	public ResponseEntity<?> createTest(@RequestBody Test test) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<Test>(testService.addTest(test), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

	/*
	 * Method to get all tests
	 */
	@GetMapping("/getalltests")
	@Operation(summary = "Get all tests")
	public List<Test> getTests(){
		return testService.getAllTest();		
		
	}
	
	/*
	 * Method to get test by id
	 */
	@GetMapping("/getOnetest/{testId}")
	public Test getOneTestById(@PathVariable(value="testId")Long id) {
		return testService.getTestById(id);
		
	}
	/*
	 * Method to get test by name
	 */
	@GetMapping("/getOnetestbyname/{testName}")
	public Test getOneTestById(@PathVariable(value="testName")String name) {
		return testService.getTestByName(name);
		
	}
	/*
	 * Method to remove test
	 */
	@DeleteMapping("/removeTest/{testId}")
	public void deleteTest(@PathVariable(value="testId") Long id) {
		testService.removeTest(id);
	}
	/*
	 * Method to edit test 
	 */
	@PutMapping(value="/editTest")
	public  ResponseEntity<?> editTest(@RequestBody Test test) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<Test>(testService.updateTest(test), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
}
