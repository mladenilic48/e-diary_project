package com.ITtraining.gradebook.entities;

import java.util.ArrayList;
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
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "teachers")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TeacherEntity extends UserEntity {

	@Column(name = "Id")
	@Id
	@GeneratedValue
	@JsonProperty("Id")
	private Integer id;

	@Column(name = "vocation")
	private String vocation;

	@OneToMany(mappedBy = "teacherSubject_Teacher", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<TeacherSubjectEntity> teacher_TeacherSubjects = new ArrayList<>();

	@OneToMany(mappedBy = "teacherPupil_Teacher", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<TeacherPupilEntity> teacher_TeacherPupils = new ArrayList<>();

	@OneToMany(mappedBy = "teacherSchool_Teacher", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<TeacherSchoolEntity> teacher_TeacherSchool = new ArrayList<>();

	public TeacherEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVocation() {
		return vocation;
	}

	public void setVocation(String vocation) {
		this.vocation = vocation;
	}

	public List<TeacherPupilEntity> getTeacher_TeacherPupils() {
		return teacher_TeacherPupils;
	}

	public void setTeacher_TeacherPupils(List<TeacherPupilEntity> teacher_TeacherPupils) {
		this.teacher_TeacherPupils = teacher_TeacherPupils;
	}

	public List<TeacherSubjectEntity> getTeacher_TeacherSubjects() {
		return teacher_TeacherSubjects;
	}

	public void setTeacher_TeacherSubjects(List<TeacherSubjectEntity> teacher_TeacherSubjects) {
		this.teacher_TeacherSubjects = teacher_TeacherSubjects;
	}

	public List<TeacherSchoolEntity> getTeacher_TeacherSchool() {
		return teacher_TeacherSchool;
	}

	public void setTeacher_TeacherSchool(List<TeacherSchoolEntity> teacher_TeacherSchool) {
		this.teacher_TeacherSchool = teacher_TeacherSchool;
	}
}
