package com.Report.Service.ServiceImpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Report.Enum.SlotStatusEnum;
import com.Report.Exception.ResourceNotFoundException;
import com.Report.Repository.ProjectRepository;
import com.Report.Repository.WeekPlanRepository;
import com.Report.Repository.WeeklyProgressRepository;
import com.Report.Service.ProgressService;
import com.Report.Service.bo.AddWeekPlanBo;
import com.Report.Service.bo.CreateProjectBo;
import com.Report.Service.bo.WeeklyProgressBo;
import com.Report.entity.ProjectEntity;
import com.Report.entity.WeekPlanEntity;
import com.Report.entity.WeeklyProgressEntity;
import com.Report.resource.AppConstant;
import com.Report.response.AddWeekPlanResponse;
import com.Report.response.CreateProjectResponse;
import com.Report.response.WeeklyProgressDetailResponse;
import com.Report.response.WeeklyProgressResponse;



@Service
@Component
public class ProgressServiceImpl implements ProgressService{
	
	@Autowired
	private WeeklyProgressRepository weeklyProgressRepository;
	

	@Autowired
	private WeekPlanRepository weekPlanRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	

	@Override
	public WeeklyProgressResponse weeklyProgress(WeeklyProgressBo weeklyProgressBo) {

		WeeklyProgressEntity entity = new WeeklyProgressEntity();
//		ProjectEntity projectEntity = projectRepository.findById(weeklyProgressBo.getProjectId()).orElse(null);
//		projectEntity.getId();
		WeekPlanEntity weekPlanEntity = weekPlanRepository.findById(weeklyProgressBo.getWeekPlanId()).orElse(null);
		weekPlanEntity.getId();
//		entity.setProjectId(projectEntity);
		entity.setWeekPlanId(weekPlanEntity);
		entity.setWeek_no(weeklyProgressBo.getWeekNumber());
		entity.setStartWeekDate(weeklyProgressBo.getStartWeekDate());
		entity.setEndWeekDate(weeklyProgressBo.getEndWeektDate());
		entity.setNextWeekPlan(weeklyProgressBo.getNextWeekPlan());
		
		weeklyProgressRepository.save(entity);

		WeeklyProgressResponse response = new WeeklyProgressResponse();
		response.setWeeklyProgressSuccessfullyAdded(true);
		return response;
	}

	@Override
	public AddWeekPlanResponse addWeekPlan(AddWeekPlanBo addWeekPlanBo) {

		WeekPlanEntity entity = new WeekPlanEntity();
		entity.setId(addWeekPlanBo.getWeekPlanId());
		entity.setSlot_description(addWeekPlanBo.getSlotDescription());
		entity.setSlotStatus(addWeekPlanBo.getSlotStatus());
		weekPlanRepository.save(entity);

		AddWeekPlanResponse response = new AddWeekPlanResponse();
		response.setWeekPlanAdded(true);
		return response;
	}

	@Override
	public WeeklyProgressDetailResponse getDetaisWeeklyProgress(Long weeklyProgressId) {
	//	WeeklyProgressEntity weeklyProgressEntity=new WeeklyProgressEntity();
		
		
		WeekPlanEntity weekPlanEntity= weekPlanRepository.findById(weeklyProgressId).orElseThrow(() -> new ResourceNotFoundException(AppConstant.ErrorTypes.ENTITY_NOT_EXISTS_ERROR,
				AppConstant.ErrorCodes.ENTITY_NOT_EXISTS_ERROR_CODE,
				AppConstant.ErrorMessages.ENTITY_NOT_EXISTS_ERROR_MESSAGE));
		
		WeeklyProgressEntity weeklyProgressEntity=weeklyProgressRepository.findByWeekPlanId(weekPlanEntity);
		
	//	if(!weekPlanEntity.getSlotStatus().equals("Done")) {
		if(weekPlanEntity.getSlotStatus()!=SlotStatusEnum.Done) {
				
			
		
		        	if(weeklyProgressEntity.getEndWeekDate().isBefore(LocalDateTime.now()))
		         	{
			         	weeklyProgressEntity.setStartWeekDate(weeklyProgressEntity.getEndWeekDate());
			         	weeklyProgressEntity.setEndWeekDate(weeklyProgressEntity.getEndWeekDate().plusDays(6));
		        		weeklyProgressEntity.setWeek_no(weeklyProgressEntity.getWeek_no()+1);
	        			weeklyProgressRepository.save(weeklyProgressEntity);		
		        		WeeklyProgressDetailResponse response=new WeeklyProgressDetailResponse();
//		        		response.setProjectId(weeklyProgressEntity.getProjectId());
	         			response.setEndWeektDate(weeklyProgressEntity.getEndWeekDate());
	        			response.setStartWeekDate(weeklyProgressEntity.getStartWeekDate());
	        			response.setWeek_no(weeklyProgressEntity.getWeek_no());
	        			response.setWeeklyProgressId(weeklyProgressEntity.getId());
	        			response.setWeekPlanId(weeklyProgressEntity.getWeekPlanId());
	        			return response;
		           	}
		
		           else
		            {
			          return convertToModels13(weeklyProgressEntity);
						
		             }
		}
		
		   else
				return convertToModels13(weeklyProgressEntity);
				
				
	}
	
	
	private WeeklyProgressDetailResponse convertToModels13(WeeklyProgressEntity entity1) {
		return WeeklyProgressDetailResponse.builder().weeklyProgressId(entity1.getId())
//				  .projectId(entity1.getProjectId())
				  .startWeekDate(entity1.getStartWeekDate())
				  .endWeektDate(entity1.getEndWeekDate())
				  .week_no(entity1.getWeek_no())
				  .build();
	}

	@Override
	public CreateProjectResponse createProject(CreateProjectBo createProjectBo) {

		ProjectEntity entity = new ProjectEntity();

		entity.setName(createProjectBo.getName());
		entity.setProjectdescription(createProjectBo.getProjectDescription());
		entity.setProjectstatus(createProjectBo.getProjectstatus());
		entity.setStartdate(createProjectBo.getStartDate());
		entity.setEnddate(createProjectBo.getEndDate());
		projectRepository.save(entity);

		CreateProjectResponse response = new CreateProjectResponse();
		response.setProjectCreationSuccessful(true);
		return response;
	}

}
