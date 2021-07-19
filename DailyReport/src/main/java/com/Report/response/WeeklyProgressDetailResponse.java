package com.Report.response;

import java.time.LocalDateTime;

import com.Report.entity.WeekPlanEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeeklyProgressDetailResponse {
	private Long weeklyProgressId;
//	private ProjectEntity projectId;
	private int week_no;
	private LocalDateTime startWeekDate;
	private LocalDateTime endWeektDate;
	private WeekPlanEntity weekPlanId;

}
