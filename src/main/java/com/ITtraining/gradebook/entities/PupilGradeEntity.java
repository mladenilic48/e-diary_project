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
@Table(name = "pupil_grade")
public class PupilGradeEntity {

	@Column(name = "Id")
	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "pupil_Id")
	private PupilEntity pupilGrade_Pupil;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "grade_Id")
	private GradeEntity pupilGrade_Grade;

	public PupilGradeEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PupilEntity getPupilgradePupil() {
		return pupilGrade_Pupil;
	}

	public void setPupilgradePupil(PupilEntity pupilgradePupil) {
		this.pupilGrade_Pupil = pupilgradePupil;
	}

	public GradeEntity getPupilgradeGrade() {
		return pupilGrade_Grade;
	}

	public void setPupilgradeGrade(GradeEntity pupilgradeGrade) {
		this.pupilGrade_Grade = pupilgradeGrade;
	}

	public PupilEntity getPupilGrade_Pupil() {
		return pupilGrade_Pupil;
	}

	public void setPupilGrade_Pupil(PupilEntity pupilGrade_Pupil) {
		this.pupilGrade_Pupil = pupilGrade_Pupil;
	}

	public GradeEntity getPupilGrade_Grade() {
		return pupilGrade_Grade;
	}

	public void setPupilGrade_Grade(GradeEntity pupilGrade_Grade) {
		this.pupilGrade_Grade = pupilGrade_Grade;
	}
}
