package com.pratian.AppointmentService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pratian.AppointmentService.Entities.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long>{

    @Query(value="from Feedback where id=:id")
	public Feedback findByFeedId(@Param(value="id") Long id);
}

