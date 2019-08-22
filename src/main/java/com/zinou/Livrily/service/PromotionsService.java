package com.zinou.Livrily.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zinou.Livrily.model.Produit;
@Service
public interface PromotionsService {

	

	int PostPromotion(Produit produit);

	List<Produit> getPromotion(int categorieProduit_ID);
	

}
