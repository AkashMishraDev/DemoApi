package com.Report.Request;

import com.Report.Enum.SlotStatusEnum;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AddWeekPlanRequest {
	
    private Long weekPlanId;
	private String slotDescription;
	private SlotStatusEnum slotStatus;

}
