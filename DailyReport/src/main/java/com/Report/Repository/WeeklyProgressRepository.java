package com.Report.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Report.entity.WeekPlanEntity;
import com.Report.entity.WeeklyProgressEntity;



public interface WeeklyProgressRepository extends JpaRepository<WeeklyProgressEntity, Long>{

	WeeklyProgressEntity findByWeekPlanId(WeekPlanEntity weekPlanEntity);

}
