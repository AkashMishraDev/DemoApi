package com.Report.Request;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class WeeklyProgressRequest {
	
	private Long projectId;
	private int weekNumber;
	private LocalDateTime startWeekDate;
	private LocalDateTime endWeektDate;
	private Long weekPlanId;
	private String nextWeekPlan;

}
