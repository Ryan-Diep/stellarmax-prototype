package com.stellarmaxprototype.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.stellarmaxprototype.entity.Job;

public interface JobService {
	List<Job> getAllJobs();
	
	Job saveJob(Job jobs);
	
	Job getJobById(Long id);
	
	Job updateJob(Job jobs);
	
	void deleteJobById(Long id);
	
	String getExtension(String beforePhoto);
}
