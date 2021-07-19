package com.Report.Service;

import com.Report.Service.bo.AddWeekPlanBo;
import com.Report.Service.bo.CreateProjectBo;
import com.Report.Service.bo.WeeklyProgressBo;
import com.Report.response.AddWeekPlanResponse;
import com.Report.response.CreateProjectResponse;
import com.Report.response.WeeklyProgressDetailResponse;
import com.Report.response.WeeklyProgressResponse;

public interface ProgressService {
	
	CreateProjectResponse createProject(CreateProjectBo createProjectBo);

	WeeklyProgressResponse weeklyProgress(WeeklyProgressBo weeklyProgressBo);

	AddWeekPlanResponse addWeekPlan(AddWeekPlanBo addWeekPlanBo);
	
	WeeklyProgressDetailResponse getDetaisWeeklyProgress(Long weeklyProgressId);

}
