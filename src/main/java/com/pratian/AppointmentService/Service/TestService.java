package com.pratian.AppointmentService.Service;

import java.util.List;

import com.pratian.AppointmentService.Entities.Test;
import com.pratian.AppointmentService.Exceptions.AppointmentNotFoundException;

public interface TestService {
	public Test addTest(Test test) throws AppointmentNotFoundException;
	public Test getTestByName(String testName);
	public Test getTestById(long testId);
	public List<Test> getAllTest();
	public void removeTest(long testId);
	public Test updateTest(Test test) throws AppointmentNotFoundException;
}
