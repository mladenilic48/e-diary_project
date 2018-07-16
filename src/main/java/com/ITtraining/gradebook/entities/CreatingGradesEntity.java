package com.ITtraining.gradebook.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "creating_grades")
public class CreatingGradesEntity {

	@Column(name = "Id")
	@Id
	@GeneratedValue
	@JsonProperty("Id")
	private Integer id;

	@Column(name = "created_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date createdDate;

	@Column(name = "semester")
	private Integer semester;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "category")
	private CategoryGradesEntity creatingGrades_CategoryGrade;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "pupil")
	private PupilEntity creatingGrades_Pupil;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "subject")
	private SubjectEntity creatingGrades_Subject;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "grade")
	private GradeEntity creatingGrades_Grade;

	public CreatingGradesEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

	public CategoryGradesEntity getCreatingGrades_CategoryGrade() {
		return creatingGrades_CategoryGrade;
	}

	public void setCreatingGrades_CategoryGrade(CategoryGradesEntity creatingGrades_CategoryGrade) {
		this.creatingGrades_CategoryGrade = creatingGrades_CategoryGrade;
	}

	public PupilEntity getCreatingGrades_Pupil() {
		return creatingGrades_Pupil;
	}

	public void setCreatingGrades_Pupil(PupilEntity creatingGrades_Pupil) {
		this.creatingGrades_Pupil = creatingGrades_Pupil;
	}

	public SubjectEntity getCreatingGrades_Subject() {
		return creatingGrades_Subject;
	}

	public void setCreatingGrades_Subject(SubjectEntity creatingGrades_Subject) {
		this.creatingGrades_Subject = creatingGrades_Subject;
	}

	public GradeEntity getCreatingGrades_Grade() {
		return creatingGrades_Grade;
	}

	public void setCreatingGrades_Grade(GradeEntity creatingGrades_Grade) {
		this.creatingGrades_Grade = creatingGrades_Grade;
	}

}
