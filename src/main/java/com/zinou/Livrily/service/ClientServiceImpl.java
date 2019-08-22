package com.zinou.Livrily.service;

import com.zinou.Livrily.model.Client;
import com.zinou.Livrily.repository.ClientRepository;
import com.zinou.Livrily.repository.ClientRepositoryImpl;

public class ClientServiceImpl implements ClientService {

	ClientRepository Repository = new ClientRepositoryImpl();
	
	@Override
	public Client getClient(int client_id) {
		return Repository.getClient(client_id);
	}

}
