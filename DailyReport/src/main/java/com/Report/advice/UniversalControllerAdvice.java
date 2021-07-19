package com.Report.advice;

import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.Report.Exception.InvalidInputException;
import com.Report.Exception.ResourceNotFoundException;
import com.Report.resource.AppConstant;
import com.Report.response.BaseApiResponse;
import com.Report.response.ResponseStatus;




public class UniversalControllerAdvice extends ResponseEntityExceptionHandler{
	
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<FieldError> allBindingErrorsList = ex.getBindingResult().getFieldErrors();
		List<String> allBindingErrorsMessageList = new ArrayList<String>();

		for (FieldError error : allBindingErrorsList) {
			allBindingErrorsMessageList.add(error.getField() + " - " + error.getDefaultMessage());
		}

		BaseApiResponse baseApiResponse = new BaseApiResponse();
		baseApiResponse.setResponseStatus(new ResponseStatus(AppConstant.StatusCodes.FAILURE));

		InvalidInputException invalidInputException = new InvalidInputException(
				AppConstant.ErrorTypes.INVALID_INPUT_ERROR, AppConstant.ErrorCodes.INVALID_INPUT_ERROR_CODE,
				allBindingErrorsMessageList.toString());

		baseApiResponse.setResponseData(invalidInputException);

		return new ResponseEntity<Object>(baseApiResponse, HttpStatus.OK);
	}
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<BaseApiResponse> userNotFoundException(ResourceNotFoundException resourceNotFoundException,
			HttpServletRequest request) {
		BaseApiResponse baseApiResponse = new BaseApiResponse();
		baseApiResponse.setResponseStatus(new ResponseStatus(AppConstant.StatusCodes.FAILURE));
		baseApiResponse.setResponseData(resourceNotFoundException);
		return new ResponseEntity<BaseApiResponse>(baseApiResponse, HttpStatus.OK);
	}
	
}