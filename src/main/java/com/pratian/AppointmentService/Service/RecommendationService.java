package com.pratian.AppointmentService.Service;

import java.util.List;

import com.pratian.AppointmentService.Entities.DoctorDetails;
import com.pratian.AppointmentService.Entities.Recommendation;
import com.pratian.AppointmentService.Exceptions.DoctorNameNotFoundException;



public interface RecommendationService {
	Recommendation addRecommendation (Recommendation rec)throws  DoctorNameNotFoundException;
	//void removeRecommendation(long recommendationId);
	void removeRecommedation(long recommendationId)throws DoctorNameNotFoundException ;
	List<Recommendation> getAllRecommendation() throws DoctorNameNotFoundException ;
	List<DoctorDetails> getAllDoctors()throws DoctorNameNotFoundException;
	}
