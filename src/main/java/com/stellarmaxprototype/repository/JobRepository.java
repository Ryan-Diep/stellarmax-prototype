package com.stellarmaxprototype.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stellarmaxprototype.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
     
}