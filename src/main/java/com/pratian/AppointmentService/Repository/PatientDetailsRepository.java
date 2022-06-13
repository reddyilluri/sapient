package com.pratian.AppointmentService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pratian.AppointmentService.Entities.PatientDetails;


@Repository
public interface PatientDetailsRepository extends JpaRepository<PatientDetails, Long> {
	//@Query(value="select c from Comment c where c.Id=:id")
	public PatientDetails getPatientDetailsById(long id);


}
