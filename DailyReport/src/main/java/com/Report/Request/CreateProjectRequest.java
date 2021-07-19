package com.Report.Request;

import java.time.LocalDateTime;

import com.Report.Enum.ProjectStatusEnum;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProjectRequest {
	private String name ;
	private String projectDescription; 
	private ProjectStatusEnum projectstatus;
	private LocalDateTime startDate;
	private LocalDateTime endDate;

}
