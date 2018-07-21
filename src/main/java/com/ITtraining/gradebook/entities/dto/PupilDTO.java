package com.ITtraining.gradebook.entities.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PupilDTO {

	@NotNull(message = "Name must be provided.")
	private String name;
	
	@NotNull(message = "Surname must be provided.")
	private String surname;
	
	@NotNull(message = "Username must be provided.")
	@Size(min = 5, max = 20, message = "Username must be between {min} and {max} characters long.")
	private String username;
	
	@NotNull(message = "Password must be provided.")
	@Pattern(regexp = "^[A-Za-z0-9]{5,}$", message = "Password is not valid.")
	private String password;
	
	private String uniquePupilNumber;

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

}
