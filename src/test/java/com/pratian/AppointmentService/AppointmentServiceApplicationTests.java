package com.pratian.AppointmentService;

import com.pratian.AppointmentService.Controller.AppointmentController;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppointmentServiceApplicationTests {
	@Autowired
	AppointmentController app;
	
	@Test
	void totalAppointmentsTest() {
		assertEquals(3, app.getTotalAppointments());
	}
	
	@Test
	void cancelledAppointmentsTest() {
		assertEquals(1, app.getCancelledAppointments());
	}
	
	@Test
	void acceptedAppointmentsTest() {
		assertEquals(2, app.getacceptedAppointments());
	}

}
