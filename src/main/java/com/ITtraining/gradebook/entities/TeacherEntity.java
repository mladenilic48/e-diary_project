package com.ITtraining.gradebook.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "teachers")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TeacherEntity extends UserEntity {

	@Column(name = "Id")
	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "vocation")
	private String vocation;

	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@Column(name = "edu_title")
	private String educationTitle;

	@OneToMany(mappedBy = "subject_Teacher", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<SubjectEntity> teacher_Subjects = new ArrayList<>();

	@OneToMany(mappedBy = "teacherPupil_Teacher", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<TeacherPupilEntity> teacher_TeacherPupils = new ArrayList<>();

	public TeacherEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getVocation() {
		return vocation;
	}

	public void setVocation(String vocation) {
		this.vocation = vocation;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEducationTitle() {
		return educationTitle;
	}

	public void setEducationTitle(String educationTitle) {
		this.educationTitle = educationTitle;
	}

	public List<SubjectEntity> getTeacher_Subjects() {
		return teacher_Subjects;
	}

	public void setTeacher_Subjects(List<SubjectEntity> teacher_Subjects) {
		this.teacher_Subjects = teacher_Subjects;
	}

	public List<TeacherPupilEntity> getTeacher_TeacherPupils() {
		return teacher_TeacherPupils;
	}

	public void setTeacher_TeacherPupils(List<TeacherPupilEntity> teacher_TeacherPupils) {
		this.teacher_TeacherPupils = teacher_TeacherPupils;
	}
}
