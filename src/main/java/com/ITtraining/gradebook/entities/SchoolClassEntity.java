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
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "school_classes")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class SchoolClassEntity {

	@Column(name = "Id")
	@Id
	@GeneratedValue
	@JsonProperty("Id")
	private Integer id;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "school_grade")
	private SchoolGradeEntity schoolGrade;

	@Column(name = "class_no")
	private Integer classNumber;

	@OneToMany(mappedBy = "pupil_SchoolClass", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<PupilEntity> schoolClass_Pupils = new ArrayList<>();

	public SchoolClassEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(Integer classNumber) {
		this.classNumber = classNumber;
	}

	public List<PupilEntity> getSchoolClass_Pupils() {
		return schoolClass_Pupils;
	}

	public void setSchoolClass_Pupils(List<PupilEntity> schoolClass_Pupils) {
		this.schoolClass_Pupils = schoolClass_Pupils;
	}

	public SchoolGradeEntity getSchoolGrade() {
		return schoolGrade;
	}

	public void setSchoolGrade(SchoolGradeEntity schoolGrade) {
		this.schoolGrade = schoolGrade;
	}

}
