package com.Report.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Report.Converter.ResourceMasterConverter;
import com.Report.Request.AddWeekPlanRequest;
import com.Report.Request.CreateProjectRequest;
import com.Report.Request.WeeklyProgressRequest;
import com.Report.Service.ServiceImpl.ProgressServiceImpl;
import com.Report.Service.bo.AddWeekPlanBo;
import com.Report.Service.bo.CreateProjectBo;
import com.Report.Service.bo.WeeklyProgressBo;
import com.Report.response.AddWeekPlanResponse;
import com.Report.response.BaseApiResponse;
import com.Report.response.CreateProjectResponse;
import com.Report.response.ResponseBuilder;
import com.Report.response.WeeklyProgressResponse;





@RestController
public class ProgressController {
	
	@Autowired
	private ProgressServiceImpl progressService;
	
	@PostMapping("/weeklyProgress")
	ResponseEntity<BaseApiResponse> weeklyProgress(@RequestBody WeeklyProgressRequest weeklyProgressRequest,
			HttpServletRequest request) {
		// String empId=request.getHeader(AppConstants.Commons.EMPLOYEE_ID);
		WeeklyProgressBo weeklyProgressBo = ResourceMasterConverter
				.prepareWeeklyProgressBoFromRequest(weeklyProgressRequest);
		WeeklyProgressResponse response = progressService.weeklyProgress(weeklyProgressBo);
		BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(response);
		return new ResponseEntity<BaseApiResponse>(baseApiResponse, HttpStatus.OK);
	}
	
	@PostMapping("/createProject")
	ResponseEntity<BaseApiResponse>createProject(@RequestBody CreateProjectRequest createProjectRequest,
			HttpServletRequest request){
		//String empId=request.getHeader(AppConstants.Commons.EMPLOYEE_ID);
		CreateProjectBo createProjectBo=ResourceMasterConverter.prepareCreateProjectBoFromRequest(createProjectRequest);
		CreateProjectResponse response=progressService.createProject(createProjectBo);
		BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(response);
		return new ResponseEntity<BaseApiResponse>(baseApiResponse, HttpStatus.OK);
	}
	
	@PostMapping("/getDetailWeeklyProgress")
	ResponseEntity<BaseApiResponse> getDetaisWeeklyProgress(HttpServletRequest request, @RequestParam Long weeklyProgressId ) {


		BaseApiResponse baseApiResponse = ResponseBuilder
				.getSuccessResponse(progressService.getDetaisWeeklyProgress(weeklyProgressId));
		return new ResponseEntity<BaseApiResponse>(baseApiResponse, HttpStatus.OK);
	}
	
	
	@PostMapping("/addWeekPlan")
	ResponseEntity<BaseApiResponse> addWeekPlan(@RequestBody AddWeekPlanRequest addWeekPlanRequest,
			HttpServletRequest request) {
		// String empId=request.getHeader(AppConstants.Commons.EMPLOYEE_ID);
		AddWeekPlanBo addWeekPlanBo = ResourceMasterConverter.prepareAddWeekPlanBoFromRequest(addWeekPlanRequest);
		AddWeekPlanResponse response = progressService.addWeekPlan(addWeekPlanBo);
		BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(response);
		return new ResponseEntity<BaseApiResponse>(baseApiResponse, HttpStatus.OK);
	}

}
