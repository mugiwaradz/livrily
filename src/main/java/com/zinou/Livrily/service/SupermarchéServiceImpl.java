package com.zinou.Livrily.service;

import com.zinou.Livrily.model.Supermarché;
import com.zinou.Livrily.repository.SupermarchéRepository;
import com.zinou.Livrily.repository.SupermarchéRepositoryImpl;

public class SupermarchéServiceImpl implements SupermarchéService {

	
	SupermarchéRepository repository= new SupermarchéRepositoryImpl();

	@Override
	public Supermarché AjouterSupermarché(Supermarché supermarché) {
		return repository.AjouterSupermarché(supermarché);
	}

	@Override
	public boolean suprimerSupermarché(int id_supermarché) {

		return repository.SupprimerSupermarché(id_supermarché);
	}



}
