package com.ITtraining.gradebook.controllers.util;

public class RESTError {

	private Integer code;

	private String message;

	public RESTError(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
