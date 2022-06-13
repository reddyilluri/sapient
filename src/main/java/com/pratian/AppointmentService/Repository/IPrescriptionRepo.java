package com.pratian.AppointmentService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pratian.AppointmentService.Entities.Prescriptions;

//written by pooja

@Repository
public interface IPrescriptionRepo  extends JpaRepository<Prescriptions, Long>,CrudRepository<Prescriptions, Long>{
	
}
