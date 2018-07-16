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
@Table(name = "teacher_subject")
public class TeacherSubjectEntity {

	@Column(name = "Id")
	@Id
	@GeneratedValue
	@JsonProperty("Id")
	private Integer id;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher")
	private TeacherEntity teacherSubject_Teacher;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "subject")
	private SubjectEntity teacherSubject_Subject;

	public TeacherSubjectEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TeacherEntity getTeacherSubject_Teacher() {
		return teacherSubject_Teacher;
	}

	public void setTeacherSubject_Teacher(TeacherEntity teacherSubject_Teacher) {
		this.teacherSubject_Teacher = teacherSubject_Teacher;
	}

	public SubjectEntity getTeacherSubject_Subject() {
		return teacherSubject_Subject;
	}

	public void setTeacherSubject_Subject(SubjectEntity teacherSubject_Subject) {
		this.teacherSubject_Subject = teacherSubject_Subject;
	}

}
