package com.zinou.Livrily.service;

import org.springframework.stereotype.Service;

import com.zinou.Livrily.model.Supermarché;

@Service
public interface SupermarchéService {
	
	
	
	Supermarché AjouterSupermarché(Supermarché supermarché);
	
	boolean suprimerSupermarché(int id_supermarché);

}
