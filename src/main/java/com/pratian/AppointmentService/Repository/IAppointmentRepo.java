package com.pratian.AppointmentService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.pratian.AppointmentService.Entities.Appointment;
import com.pratian.AppointmentService.Entities.DoctorDetails;

@Repository
public interface IAppointmentRepo extends JpaRepository<Appointment, Long>{
	@Query("select m from Appointment m  where m.id= :id")
	public Appointment getTestsforAppointment(@Param(value="id") long id);
	
	 @Query("select a from Appointment a where a.id = :id")
	  public Appointment getAppointmentByIdForRecommendation(@Param(value="id") long id);
	

		@Query(value="select a from Appointment a where a.id=:id")
		public Appointment getAppointmentById(long id);
		
		@Query(value="select d from  DoctorDetails d where d.id=:id")
		public DoctorDetails getDoctorDetailsById(@Param(value ="id")long id);
	
}
	

