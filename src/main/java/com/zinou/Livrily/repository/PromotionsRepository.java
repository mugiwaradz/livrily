package com.zinou.Livrily.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zinou.Livrily.model.Produit;

@Service
public interface PromotionsRepository {



	int postPromotion(int promotion, int produit_ID);

	List<Produit> getPromotion(int categorieProduit_ID);

}
