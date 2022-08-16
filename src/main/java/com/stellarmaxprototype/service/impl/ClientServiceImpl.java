package com.stellarmaxprototype.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stellarmaxprototype.entity.Client;
import com.stellarmaxprototype.repository.ClientRepository;
import com.stellarmaxprototype.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
	
	private ClientRepository clientRepository;
	
	public ClientServiceImpl(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}
	
	@Override
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

	@Override
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Client getClientById(Long id) {
		return clientRepository.findById(id).get();
	}

	@Override
	public Client updateClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public void deleteClientById(Long id) {
		clientRepository.deleteById(id);	
	}

}
