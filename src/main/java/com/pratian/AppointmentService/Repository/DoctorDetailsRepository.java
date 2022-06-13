package com.pratian.AppointmentService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pratian.AppointmentService.Entities.DoctorDetails;


@Repository
public interface DoctorDetailsRepository extends JpaRepository<DoctorDetails, Long> {
	//@Query(value="select c from Comment c where c.Id=:id")
	public DoctorDetails getDoctorDetailsById(long id);


}
