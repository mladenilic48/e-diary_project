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
@Table(name = "pupil_subject")
public class PupilSubjectEntity {

	@Column(name = "Id")
	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "pupil_Id")
	private PupilEntity pupilSubject_Pupil;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name="subject_Id")
	private SubjectEntity pupilSubject_Subject;

	public PupilSubjectEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PupilEntity getPupilSubject_Pupil() {
		return pupilSubject_Pupil;
	}

	public void setPupilSubject_Pupil(PupilEntity pupilSubject_Pupil) {
		this.pupilSubject_Pupil = pupilSubject_Pupil;
	}

	public SubjectEntity getPupilSubject_Subject() {
		return pupilSubject_Subject;
	}

	public void setPupilSubject_Subject(SubjectEntity pupilSubject_Subject) {
		this.pupilSubject_Subject = pupilSubject_Subject;
	}

}
