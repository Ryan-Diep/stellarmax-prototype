package com.stellarmaxprototype.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jobs")
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false, unique = true, length = 45)
    private String email;
	
	@Column(nullable = false, length = 64)
    private String service;
    
	@Column(nullable = false, length = 64)
    private String beforePhoto;
	
	@Column(nullable = false, length = 64)
    private String afterPhoto;
    
	public Job() {
		
	}
	
	public Job(String service, String beforePhoto, String afterPhoto, String email) {
		super();
		this.service = service;
		this.beforePhoto = beforePhoto;
		this.afterPhoto = afterPhoto;
		this.email = email;
	}
	
    public Long getId() {
		return id;
	}
    
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getService() {
		return service;
	}
	
	public void setService(String service) {
		this.service = service;
	}
	
	public String getBeforePhoto() {
		return beforePhoto;
	}
	
	public void setBeforePhoto(String beforePhoto) {
		this.beforePhoto = beforePhoto;
	}
	
	public String getAfterPhoto() {
		return afterPhoto;
	}
	
	public void setAfterPhoto(String afterPhoto) {
		this.afterPhoto = afterPhoto;
	}
	
  }