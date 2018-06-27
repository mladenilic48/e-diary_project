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

@Entity
@Table(name = "teacher_pupil")
public class TeacherPupilEntity {

	@Column(name = "Id")
	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher_Id")
	private TeacherEntity teacherPupil_Teacher;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "pupil_Id")
	private PupilEntity teacherPupil_Pupil;

	public TeacherPupilEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TeacherEntity getTeacherPupil_Teacher() {
		return teacherPupil_Teacher;
	}

	public void setTeacherPupil_Teacher(TeacherEntity teacherPupil_Teacher) {
		this.teacherPupil_Teacher = teacherPupil_Teacher;
	}

	public PupilEntity getTeacherPupil_Pupil() {
		return teacherPupil_Pupil;
	}

	public void setTeacherPupil_Pupil(PupilEntity teacherPupil_Pupil) {
		this.teacherPupil_Pupil = teacherPupil_Pupil;
	}

}
