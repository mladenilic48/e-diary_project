package com.ITtraining.gradebook.entities;

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
@Table(name = "grades")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class GradeEntity {

	@Column(name = "Id")
	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "grade")
	private Integer grade;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "pupilGrade_Grade", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<PupilGradeEntity> grade_PupilGrades;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<PupilGradeEntity> getGrade_PupilGrades() {
		return grade_PupilGrades;
	}

	public void setGrade_PupilGrades(List<PupilGradeEntity> grade_PupilGrades) {
		this.grade_PupilGrades = grade_PupilGrades;
	}

}
