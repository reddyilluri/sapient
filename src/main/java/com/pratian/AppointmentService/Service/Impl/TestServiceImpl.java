package com.pratian.AppointmentService.Service.Impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratian.AppointmentService.Entities.Appointment;
import com.pratian.AppointmentService.Entities.Test;
import com.pratian.AppointmentService.Exceptions.AppointmentNotFoundException;
import com.pratian.AppointmentService.Repository.IAppointmentRepo;
import com.pratian.AppointmentService.Repository.TestRepo;
import com.pratian.AppointmentService.Service.TestService;

@Service
public class TestServiceImpl implements TestService {
	@Autowired
	TestRepo testRepo;
	
	
	@Override
	public Test addTest(Test test) throws AppointmentNotFoundException {		
		List<Test> te=testRepo.
				findAll()
				.stream().
				filter(t->t.getTestName().equals(test.getTestName())).
				collect(Collectors.toList());
		if(te.size()>0)   {
			throw new AppointmentNotFoundException("Test is already present");
		}
		else {
		Test t=testRepo.saveAndFlush(test);
		return t;
		}
	}

	@Override
	public List<Test> getAllTest() {	
		return testRepo.findAll();
	}

	@Override
	public void removeTest(long testId) {
		testRepo.deleteById(testId);
		
	}

	@Override
	public Test getTestById(long testId) {
		return testRepo.getTestId(testId);
				}

	@Override
	public Test updateTest(Test test) throws AppointmentNotFoundException {
		List<Test> te=testRepo.
			 	findAll()
				.stream().
				filter(t->t.getTestName().equals(test.getTestName())).
				collect(Collectors.toList());
		if(te.size()>0)   {
			throw new AppointmentNotFoundException("Test is already present");
		}
		else {
			 Test t = testRepo.findById(test.getTestId()).get();
		        t.setTestName(test.getTestName());  	
		        return t;
		}
           
//        return testRepo.save(t);                                	
	}

	@Override
	public Test getTestByName(String testName) {
		// TODO Auto-generated method stub
		return testRepo.getTestName(testName);
	}

}
