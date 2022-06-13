package com.pratian.AppointmentService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pratian.AppointmentService.Entities.DoctorDetails;
import com.pratian.AppointmentService.Entities.Recommendation;
@Repository
public interface RecommendationRepository  extends JpaRepository<Recommendation,Long>{
	
	
}
