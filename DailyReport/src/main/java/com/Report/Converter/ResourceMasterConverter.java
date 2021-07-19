package com.Report.Converter;

import com.Report.Request.AddWeekPlanRequest;
import com.Report.Request.CreateProjectRequest;
import com.Report.Request.WeeklyProgressRequest;
import com.Report.Service.bo.AddWeekPlanBo;
import com.Report.Service.bo.CreateProjectBo;
import com.Report.Service.bo.WeeklyProgressBo;


public class ResourceMasterConverter {

	public static CreateProjectBo prepareCreateProjectBoFromRequest(CreateProjectRequest request) {

		CreateProjectBo createProjectBo = new CreateProjectBo();
		createProjectBo.setName(request.getName());
		createProjectBo.setProjectDescription(request.getProjectDescription());
		createProjectBo.setStartDate(request.getStartDate());
		createProjectBo.setEndDate(request.getEndDate());
		return createProjectBo;
	}

	public static WeeklyProgressBo prepareWeeklyProgressBoFromRequest(WeeklyProgressRequest request) {

		WeeklyProgressBo weeklyProgressBo = new WeeklyProgressBo();

		weeklyProgressBo.setProjectId(request.getProjectId());
		weeklyProgressBo.setWeekNumber(request.getWeekNumber());
		weeklyProgressBo.setStartWeekDate(request.getStartWeekDate());
		weeklyProgressBo.setEndWeektDate(request.getEndWeektDate());
		weeklyProgressBo.setWeekPlanId(request.getWeekPlanId());
		weeklyProgressBo.setNextWeekPlan(request.getNextWeekPlan());
		return weeklyProgressBo;
	}

	public static AddWeekPlanBo prepareAddWeekPlanBoFromRequest(AddWeekPlanRequest Request) {

		AddWeekPlanBo addWeekPlanBo = new AddWeekPlanBo();

		addWeekPlanBo.setWeekPlanId(Request.getWeekPlanId());
		addWeekPlanBo.setSlotDescription(Request.getSlotDescription());
		addWeekPlanBo.setSlotStatus(Request.getSlotStatus());
		return addWeekPlanBo;
	}

}
