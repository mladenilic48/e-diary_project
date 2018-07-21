package com.ITtraining.gradebook.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "school_grade")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class SchoolGradeEntity {

	@Column(name = "Id")
	@Id
	@GeneratedValue
	@JsonProperty("Id")
	private Integer id;

	@Column(name = "school_grade")
	private Integer schoolGrade;

	@OneToMany(mappedBy = "subjectGrade_SchoolGrade", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<SubjectGradeEntity> schoolGrade_SubjectGrade = new ArrayList<>();

	@OneToMany(mappedBy = "schoolGrade", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<SchoolClassEntity> schoolClass = new ArrayList<>();

	public SchoolGradeEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSchoolGrade() {
		return schoolGrade;
	}

	public void setSchoolGrade(Integer schoolGrade) {
		this.schoolGrade = schoolGrade;
	}

	public List<SubjectGradeEntity> getSchoolGrade_SubjectGrade() {
		return schoolGrade_SubjectGrade;
	}

	public void setSchoolGrade_SubjectGrade(List<SubjectGradeEntity> schoolGrade_SubjectGrade) {
		this.schoolGrade_SubjectGrade = schoolGrade_SubjectGrade;
	}

	public List<SchoolClassEntity> getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(List<SchoolClassEntity> schoolClass) {
		this.schoolClass = schoolClass;
	}

}
