package com.stellarmaxprototype.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stellarmaxprototype.service.JobService;

import com.stellarmaxprototype.entity.Job;
import com.stellarmaxprototype.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService{
	
	private JobRepository jobRepository;
	
	public JobServiceImpl(JobRepository jobRepository) {
		super();
		this.jobRepository = jobRepository;
	}
	
	@Override
	public List<Job> getAllJobs() {
		return jobRepository.findAll();
	}

	@Override
	public Job saveJob(Job jobs) {
		return jobRepository.save(jobs);
	}

	@Override
	public Job getJobById(Long id) {
		return jobRepository.findById(id).get();
	}

	@Override
	public Job updateJob(Job jobs) {
		return jobRepository.save(jobs);
	}

	@Override
	public void deleteJobById(Long id) {
		jobRepository.deleteById(id);
	}

	@Override
	public String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }
}