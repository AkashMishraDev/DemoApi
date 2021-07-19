package com.Report.Exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"cause","stackTrace","suppressed","localizedMessage"})
public class ResourceNotFoundException extends AppException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	public ResourceNotFoundException(String errorType, String errorCode, String message) {
		super(errorType, errorCode, message);
	}
}

