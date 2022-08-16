package com.stellarmaxprototype.service;

import java.util.List;

import com.stellarmaxprototype.entity.Client;

public interface ClientService {
	List<Client> getAllClients();
	
	Client saveClient(Client client);
	
	Client getClientById(Long id);
	
	Client updateClient(Client client);
	
	void deleteClientById(Long id);
}

