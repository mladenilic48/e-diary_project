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
@Table(name = "grades")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class GradeEntity {

	@Column(name = "Id")
	@Id
	@GeneratedValue
	@JsonProperty("Id")
	private Integer id;

	@Column(name = "grade")
	private Integer grade;

	@OneToMany(mappedBy = "creatingGrades_Grade", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<CreatingGradesEntity> grade_CreatingGrades = new ArrayList<>();

	public GradeEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public List<CreatingGradesEntity> getGrade_CreatingGrades() {
		return grade_CreatingGrades;
	}

	public void setGrade_CreatingGrades(List<CreatingGradesEntity> grade_CreatingGrades) {
		this.grade_CreatingGrades = grade_CreatingGrades;
	}

}
