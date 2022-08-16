package com.stellarmaxprototype.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stellarmaxprototype.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
     
}