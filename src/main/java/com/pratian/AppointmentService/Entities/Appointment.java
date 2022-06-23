package com.pratian.AppointmentService.Entities;


import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToMany;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@OneToOne
	Comment comment;
	@OneToOne
	DoctorDetails doctordetails;
	@OneToOne
	PatientDetails patientdetails;
	@Autowired	
	
	@OneToMany
	@JoinColumn(name="appointment_id")
	private List<Prescriptions> prescriptions;

	@ManyToMany
	private List<Test> tests=new ArrayList<Test>();

//	@OneToMany(targetEntity = Test.class)
//	private List<Test> tests;

	@OneToOne
	private Feedback feedback;
	
	@OneToOne
	private  Vitals vitals;
	
	@ManyToMany
	private List<Recommendation> recommendations=new ArrayList<Recommendation>();
	
	//@OneToMany
	//private List<Recommendation> recommendations;
	private String issue;
	private String date;
	private String time;
	private String status;
	private String name;
	private int age;
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Appointment(long id, Comment comment, DoctorDetails doctordetails, PatientDetails patientdetails,
			List<Prescriptions> prescriptions, List<Test> tests, Feedback feedback, Vitals vitals,
			List<Recommendation> recommendations, String issue, String date, String time, String status) {
		super();
		this.id = id;
		this.comment = comment;
		this.doctordetails = doctordetails;
		this.patientdetails = patientdetails;
		this.prescriptions = prescriptions;
		this.tests = tests;
		this.feedback = feedback;
		this.vitals = vitals;
		this.recommendations = recommendations;
		this.issue = issue;
		this.date = date;
		this.time = time;
		this.status = status;
	}
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public List<Recommendation> getRecommendations() {
		return recommendations;
	}
	public void setRecommendations(List<Recommendation> recommendations) {
		this.recommendations = recommendations;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Feedback getFeedback() {
		return feedback;
	}
	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
	

	public Vitals getVitals() {
		return vitals;
	}
	public void setVitals(Vitals vitals) {
		this.vitals = vitals;
	}
	
	public List<Prescriptions> getPrescriptions() {
		return prescriptions;
	}
	public void setPrescriptions(List<Prescriptions> prescriptions) {
		this.prescriptions = prescriptions;
	}
	public List<Test> getTests() {
		return tests;
	}
	public void setTests(List<Test> tests) {
		this.tests = tests;
	}
	public DoctorDetails getDoctordetails() {
		return doctordetails;
	}
	public void setDoctordetails(DoctorDetails doctordetails) {
		this.doctordetails = doctordetails;
	}
	public PatientDetails getPatientdetails() {
		return patientdetails;
	}
	public void setPatientdetails(PatientDetails patientdetails) {
		this.patientdetails = patientdetails;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public String getName() {
		return name;
	}
	

}

//
//@Entity
//public class Appointment {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
//	
//	@OneToMany
//	private List<Test> tests=new ArrayList<Test>();
//	
//	public List<Test> getTest() {
//		return tests;
//	}
//
//	public void setTest(List<Test> tests) {
//		this.tests = tests;
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public Appointment() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public Appointment(long id, List<Test> tests) {
//		super();
//		this.id = id;
//		this.tests = tests;
//	}
//	
//
//}
