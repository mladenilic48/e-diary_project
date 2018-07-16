package com.ITtraining.gradebook.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "subject_grade")
public class SubjectGradeEntity {

	@Column(name = "Id")
	@Id
	@GeneratedValue
	@JsonProperty("Id")
	private Integer id;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "subject")
	private SubjectEntity subjectGrade_subject;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "school_grade")
	private SchoolGradeEntity subjectGrade_SchoolGrade;

	public SubjectGradeEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SubjectEntity getSubjectGrade_subject() {
		return subjectGrade_subject;
	}

	public void setSubjectGrade_subject(SubjectEntity subjectGrade_subject) {
		this.subjectGrade_subject = subjectGrade_subject;
	}

	public SchoolGradeEntity getSubjectGrade_SchoolGrade() {
		return subjectGrade_SchoolGrade;
	}

	public void setSubjectGrade_SchoolGrade(SchoolGradeEntity subjectGrade_SchoolGrade) {
		this.subjectGrade_SchoolGrade = subjectGrade_SchoolGrade;
	}

}
