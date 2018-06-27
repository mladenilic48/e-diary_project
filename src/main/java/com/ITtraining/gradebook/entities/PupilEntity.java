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
@Table(name = "pupils")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PupilEntity extends UserEntity {

	@Column(name = "Id")
	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "uni_pupil_no")
	private String uniquePupilNumber;

	@Column(name = "school_class")
	private Integer schoolClass;

	@Column(name = "class_no")
	private Integer classNumber;

	@OneToMany(mappedBy = "teacherPupil_Pupil", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<TeacherPupilEntity> pupil_TeacherPupils = new ArrayList<>();

	@OneToMany(mappedBy = "pupilGrade_Pupil", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<PupilGradeEntity> pupil_PupilGrade = new ArrayList<>();

	@OneToMany(mappedBy = "pupilSubject_Pupil", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<PupilSubjectEntity> pupil_PupilSubject = new ArrayList<>();

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_Id")
	private ParentEntity pupil_Parent;

	public PupilEntity() {
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

	public String getUniquePupilNumber() {
		return uniquePupilNumber;
	}

	public void setUniquePupilNumber(String uniquePupilNumber) {
		this.uniquePupilNumber = uniquePupilNumber;
	}

	public Integer getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(Integer schoolClass) {
		this.schoolClass = schoolClass;
	}

	public Integer getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(Integer classNumber) {
		this.classNumber = classNumber;
	}

	public List<TeacherPupilEntity> getPupil_TeacherPupils() {
		return pupil_TeacherPupils;
	}

	public void setPupil_TeacherPupils(List<TeacherPupilEntity> pupil_TeacherPupils) {
		this.pupil_TeacherPupils = pupil_TeacherPupils;
	}

	public List<PupilGradeEntity> getPupil_PupilGrade() {
		return pupil_PupilGrade;
	}

	public void setPupil_PupilGrade(List<PupilGradeEntity> pupil_PupilGrade) {
		this.pupil_PupilGrade = pupil_PupilGrade;
	}

	public List<PupilSubjectEntity> getPupil_PupilSubject() {
		return pupil_PupilSubject;
	}

	public void setPupil_PupilSubject(List<PupilSubjectEntity> pupil_PupilSubject) {
		this.pupil_PupilSubject = pupil_PupilSubject;
	}

	public ParentEntity getPupil_Parent() {
		return pupil_Parent;
	}

	public void setPupil_Parent(ParentEntity pupil_Parent) {
		this.pupil_Parent = pupil_Parent;
	}

}
