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
@Table(name = "pupils")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PupilEntity extends UserEntity {

	@Column(name = "Id")
	@Id
	@GeneratedValue
	@JsonProperty("Id")
	private Integer id;

	@Column(name = "uni_pupil_no")
	private String uniquePupilNumber;

	@OneToMany(mappedBy = "teacherPupil_Pupil", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<TeacherPupilEntity> pupil_TeacherPupils = new ArrayList<>();

	@OneToMany(mappedBy = "creatingGrades_Pupil", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<CreatingGradesEntity> pupil_CreatingGrades = new ArrayList<>();

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "parent")
	private ParentEntity pupil_Parent;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "school_class")
	private SchoolClassEntity pupil_SchoolClass;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "school")
	private SchoolEntity school;

	public PupilEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUniquePupilNumber() {
		return uniquePupilNumber;
	}

	public void setUniquePupilNumber(String uniquePupilNumber) {
		this.uniquePupilNumber = uniquePupilNumber;
	}

	public List<TeacherPupilEntity> getPupil_TeacherPupils() {
		return pupil_TeacherPupils;
	}

	public void setPupil_TeacherPupils(List<TeacherPupilEntity> pupil_TeacherPupils) {
		this.pupil_TeacherPupils = pupil_TeacherPupils;
	}

	public ParentEntity getPupil_Parent() {
		return pupil_Parent;
	}

	public void setPupil_Parent(ParentEntity pupil_Parent) {
		this.pupil_Parent = pupil_Parent;
	}

	public List<CreatingGradesEntity> getPupil_CreatingGrades() {
		return pupil_CreatingGrades;
	}

	public void setPupil_CreatingGrades(List<CreatingGradesEntity> pupil_CreatingGrades) {
		this.pupil_CreatingGrades = pupil_CreatingGrades;
	}

	public SchoolClassEntity getPupil_SchoolClass() {
		return pupil_SchoolClass;
	}

	public void setPupil_SchoolClass(SchoolClassEntity pupil_SchoolClass) {
		this.pupil_SchoolClass = pupil_SchoolClass;
	}

	public SchoolEntity getSchool() {
		return school;
	}

	public void setSchool(SchoolEntity school) {
		this.school = school;
	}

}
