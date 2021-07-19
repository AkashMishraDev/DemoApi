package com.Report.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.Report.Enum.SlotStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Week_Plan")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeekPlanEntity extends BaseEntity{
	
	@Column(name ="slot_description",nullable = true,updatable = true)
	private String slot_description;
	
	@Column(name="slot_status", columnDefinition = "ENUM('ToStart','InProgress','Done') default 'ToStart'")
	@Enumerated(EnumType.STRING)
	private SlotStatusEnum slotStatus ;

}
