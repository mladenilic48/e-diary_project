package com.ITtraining.gradebook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pupils")
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

}
