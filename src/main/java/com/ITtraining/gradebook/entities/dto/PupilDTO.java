package com.ITtraining.gradebook.entities.dto;

public class PupilDTO {

	private String name;
	private String surname;
	private String username;
	private String password;
	private String uniquePupilNumber;
	private Integer schoolClass;
	private Integer classNumber;

	public PupilDTO() {
		super();
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
