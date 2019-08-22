package com.zinou.Livrily.repository;

import org.springframework.stereotype.Service;

import com.zinou.Livrily.model.Supermarché;

@Service
public interface SupermarchéRepository {
	
	
		
	Supermarché AjouterSupermarché(Supermarché supermarché);
	
	boolean SupprimerSupermarché(int id_supermarché);




}
