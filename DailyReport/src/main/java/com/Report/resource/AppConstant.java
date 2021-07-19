package com.Report.resource;

public interface AppConstant {
	
	public interface StatusCodes {
		int SUCCESS = 0;
		int FAILURE = 1;
	}
	
	public interface ErrorTypes{
		String INVALID_INPUT_ERROR = "Invalid Input";
		String ENTITY_NOT_EXISTS_ERROR = "Entity not Exist";

		
	}
	
	public interface ErrorCodes{
		String INVALID_INPUT_ERROR_CODE = "102";
		String ENTITY_NOT_EXISTS_ERROR_CODE = "103";

		
	}
	
	public interface ErrorMessages{

		String ENTITY_NOT_EXISTS_ERROR_MESSAGE = "Entity not exist";
		

		
	}


}