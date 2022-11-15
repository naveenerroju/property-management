package com.naveen.propertymanagement.excepetion;

import java.util.List;

public class BusinessException extends RuntimeException{
	
	private List<ErrorModel> errors;
	
	public BusinessException(List<ErrorModel> errors) {
		this.errors = errors;
	}

	public List<ErrorModel> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorModel> errors) {
		this.errors = errors;
	}

	public BusinessException() {
		super();
	}
	
}
