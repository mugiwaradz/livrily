package com.zinou.Livrily.service;

import java.util.List;

import com.zinou.Livrily.model.Produit;
import com.zinou.Livrily.repository.PromotionsRepository;
import com.zinou.Livrily.repository.PromotionsRepositoryImpl;

public class PromotionsServiceImpl implements PromotionsService {
	
	
	PromotionsRepository repository = new PromotionsRepositoryImpl();

	@Override
	public int PostPromotion(Produit produit) {
		return repository.postPromotion(produit.getPromotion(),produit.getProduit_ID());
	}

	@Override
	public List<Produit> getPromotion(int categorieProduit_ID) {
		return repository.getPromotion(categorieProduit_ID);
	}


}
