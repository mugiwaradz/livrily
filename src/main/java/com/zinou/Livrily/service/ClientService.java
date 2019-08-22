package com.zinou.Livrily.service;

import org.springframework.stereotype.Service;

import com.zinou.Livrily.model.Client;

@Service
public interface ClientService {
	
	Client getClient(int client_id);
	

}
