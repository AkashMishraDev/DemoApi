package com.Report.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Week_Progress")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeeklyProgressEntity extends BaseEntity{
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="project_Id", nullable = false)
	private ProjectEntity projectId ;
	
	
	@Column(name="week_no",nullable = false, updatable = true )
	private int week_no;
	
	@Column(name = "start_week_date", columnDefinition = "TIMESTAMP",nullable = false, updatable = true)
//	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime startWeekDate;
	
	@Column(name = "end_week_date", columnDefinition = "TIMESTAMP",nullable = false, updatable = true)
//	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime endWeekDate;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="week_plan_id", nullable = false)
	private WeekPlanEntity weekPlanId ;
	
	@Column(name="next_week_plan",nullable = true, updatable = true)
	private String nextWeekPlan;

	

	
}
