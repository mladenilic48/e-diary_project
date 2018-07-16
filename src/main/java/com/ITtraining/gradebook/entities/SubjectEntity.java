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
@Table(name = "subjects")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class SubjectEntity {

	@Column(name = "Id")
	@Id
	@GeneratedValue
	@JsonProperty("Id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "teach_load")
	private Integer teachingLoad;

	@OneToMany(mappedBy = "teacherSubject_Subject", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<TeacherSubjectEntity> subject_TeacherSubject = new ArrayList<>();

	@OneToMany(mappedBy = "creatingGrades_Subject", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<CreatingGradesEntity> subject_CreatingGrades = new ArrayList<>();

	@OneToMany(mappedBy = "subjectGrade_subject", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<SubjectGradeEntity> subject_SubjectGrade = new ArrayList<>();

	public SubjectEntity() {
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

	public Integer getTeachingLoad() {
		return teachingLoad;
	}

	public void setTeachingLoad(Integer teachingLoad) {
		this.teachingLoad = teachingLoad;
	}

	public List<TeacherSubjectEntity> getSubject_TeacherSubject() {
		return subject_TeacherSubject;
	}

	public void setSubject_TeacherSubject(List<TeacherSubjectEntity> subject_TeacherSubject) {
		this.subject_TeacherSubject = subject_TeacherSubject;
	}

	public List<CreatingGradesEntity> getSubject_CreatingGrades() {
		return subject_CreatingGrades;
	}

	public void setSubject_CreatingGrades(List<CreatingGradesEntity> subject_CreatingGrades) {
		this.subject_CreatingGrades = subject_CreatingGrades;
	}

	public List<SubjectGradeEntity> getSubject_SubjectGrade() {
		return subject_SubjectGrade;
	}

	public void setSubject_SubjectGrade(List<SubjectGradeEntity> subject_SubjectGrade) {
		this.subject_SubjectGrade = subject_SubjectGrade;
	}

}
