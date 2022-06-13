package com.pratian.AppointmentService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pratian.AppointmentService.Entities.Vitals;

@Repository
public interface VitalsRepo extends JpaRepository<Vitals, Long>{

	

	@Query(value="from Vitals where id=:id")
	Vitals findByvitalId(@Param(value="id") long id);
}
