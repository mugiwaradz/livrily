package com.zinou.Livrily.repository;

import org.springframework.stereotype.Service;

import com.zinou.Livrily.model.Client;

@Service
public interface ClientRepository {
		
	Client getClient(int client_id);



}
