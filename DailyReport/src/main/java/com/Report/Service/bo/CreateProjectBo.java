package com.Report.Service.bo;

import java.time.LocalDateTime;

import com.Report.Enum.ProjectStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateProjectBo {
	private String name;
	private String projectDescription;
	private ProjectStatusEnum projectstatus;
	private LocalDateTime startDate;
	private LocalDateTime endDate;

}
