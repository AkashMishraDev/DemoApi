package com.Report.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Report.entity.WeekPlanEntity;

public interface WeekPlanRepository extends JpaRepository<WeekPlanEntity, Long> {
	
//	  WeekPlanEntity findBySlotStatus(Long id);

}
