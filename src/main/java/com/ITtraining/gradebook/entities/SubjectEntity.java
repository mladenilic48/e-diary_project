package com.ITtraining.gradebook.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "subjects")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class SubjectEntity {

	@Column(name = "Id")
	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "teach_load")
	private Integer teachingLoad;

	@Column(name = "teach_class")
	private Integer teachingClass;

	@Column(name = "des_grade")
	private Boolean isDescriptionGrade;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_teacher")
	private TeacherEntity subject_Teacher;

	@OneToMany(mappedBy = "pupilSubject_Subject", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<PupilSubjectEntity> subject_PupilSubjects = new ArrayList<>();

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

	public Integer getTeachingClass() {
		return teachingClass;
	}

	public void setTeachingClass(Integer teachingClass) {
		this.teachingClass = teachingClass;
	}

	public Boolean getIsDescriptionGrade() {
		return isDescriptionGrade;
	}

	public void setIsDescriptionGrade(Boolean isDescriptionGrade) {
		this.isDescriptionGrade = isDescriptionGrade;
	}

	public TeacherEntity getSubject_Teacher() {
		return subject_Teacher;
	}

	public void setSubject_Teacher(TeacherEntity subject_Teacher) {
		this.subject_Teacher = subject_Teacher;
	}

	public List<PupilSubjectEntity> getSubject_PupilSubject() {
		return subject_PupilSubjects;
	}

	public void setSubject_PupilSubject(List<PupilSubjectEntity> subject_PupilSubject) {
		this.subject_PupilSubjects = subject_PupilSubject;
	}

}
