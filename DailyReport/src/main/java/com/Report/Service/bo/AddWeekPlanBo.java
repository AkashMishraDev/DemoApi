package com.Report.Service.bo;

import com.Report.Enum.SlotStatusEnum;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AddWeekPlanBo {
	
	private Long weekPlanId;
	private String slotDescription;
	private SlotStatusEnum slotStatus;

}
