package com.pratian.AppointmentService.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratian.AppointmentService.Entities.DoctorDetails;
import com.pratian.AppointmentService.Entities.Recommendation;
import com.pratian.AppointmentService.Exceptions.DoctorNameNotFoundException;
import com.pratian.AppointmentService.Repository.DoctorDetailsRepository;
import com.pratian.AppointmentService.Repository.RecommendationRepository;
import com.pratian.AppointmentService.Service.RecommendationService;

@Service
public class RecommendationServiceImpl implements RecommendationService {

	@Autowired
	RecommendationRepository repo;
	
	@Autowired
	DoctorDetailsRepository drepo;

	@Override
	public Recommendation addRecommendation(Recommendation rec) throws DoctorNameNotFoundException {
		/*
		 * boolean status; List<Recommendation> lst=new ArrayList<Recommendation>();
		 * lst=repo.findAll(); status=lst.stream().filter(
		 * obj->obj.getDoctor().getName().equals(rec.getDoctor().getName())).findFirst()
		 * .isPresent(); if(status) {
		 * 
		 * throw new DoctorNameNotFoundException("Doctor name Already exits"); } else {
		 */
			repo.saveAndFlush(rec);
			return rec;
		//}
	}

	@Override
	public void removeRecommedation(long recommendationId) throws DoctorNameNotFoundException {
		if(repo.existsById(recommendationId)) {
		repo.deleteById(recommendationId);
		}else {
			throw new DoctorNameNotFoundException("Recommendation Id not found ");
		}

	}

	@Override
	public List<Recommendation> getAllRecommendation() throws DoctorNameNotFoundException {
		if(repo.findAll()==null) {
			throw new DoctorNameNotFoundException("Data not found");
		}
		else
		return repo.findAll();
	}

	@Override
	public List<DoctorDetails> getAllDoctors() throws DoctorNameNotFoundException{
	List<DoctorDetails> drList = drepo.findAll();
		if(drepo.findAll()==null) {
			throw new DoctorNameNotFoundException("Data not found");
		}
		//return drList;
		return drList;
	}

	
}
