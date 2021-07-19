package com.Report.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.Report.Enum.ProjectStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;





@Entity
@Table(name = "Project")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectEntity extends BaseEntity {
	
	@Column(name = "name", columnDefinition = "TEXT")
	private String name;
	
	@Column(name = "project_desc")
	private String projectdescription;

	@Column(name = "project_status", columnDefinition = "ENUM('Active','Onhold','Completed') default 'Active'")
	@Enumerated(EnumType.STRING)
	private ProjectStatusEnum projectstatus;

	@Column(name = "start_date", columnDefinition = "TIMESTAMP", nullable = true, updatable = true)
//		@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime startdate;

	@Column(name = "end_date", columnDefinition = "TIMESTAMP", nullable = true, updatable = true)
//		@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime enddate;

}
