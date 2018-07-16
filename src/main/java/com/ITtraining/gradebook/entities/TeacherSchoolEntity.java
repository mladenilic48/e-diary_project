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
@Table(name = "teacher_school")
public class TeacherSchoolEntity {

	@Column(name = "Id")
	@Id
	@GeneratedValue
	@JsonProperty("Id")
	private Integer id;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher")
	private TeacherEntity teacherSchool_Teacher;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "school")
	private SchoolEntity teacherSchool_School;

	public TeacherSchoolEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TeacherEntity getTeacherSchool_Teacher() {
		return teacherSchool_Teacher;
	}

	public void setTeacherSchool_Teacher(TeacherEntity teacherSchool_Teacher) {
		this.teacherSchool_Teacher = teacherSchool_Teacher;
	}

	public SchoolEntity getTeacherSchool_School() {
		return teacherSchool_School;
	}

	public void setTeacherSchool_School(SchoolEntity teacherSchool_School) {
		this.teacherSchool_School = teacherSchool_School;
	}

}
