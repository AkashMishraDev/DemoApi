package com.Report.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Report.entity.ProjectEntity;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

}
