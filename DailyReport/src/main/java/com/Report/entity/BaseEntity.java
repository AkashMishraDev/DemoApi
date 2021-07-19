package com.Report.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class BaseEntity {
	@Column(name = "id", nullable = false, updatable = false,insertable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	
//	 @ManyToOne	
//	 @JoinColumn(name = "project_id"  )
//	   private ProjectEntity projectId;

	
	@Column(name = "created_by", updatable = false)
	@CreatedBy
	private String createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(name = "created_on",updatable = false)
	private Date createdOn;
	
	@Column(name = "updated_by")
	@LastModifiedBy
	private String updatedBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(name = "updated_on",updatable = true)
	private Date updatedOn;
	
	@Column(name = "active",columnDefinition = "BOOLEAN")
	private Boolean active = true;
	

}
