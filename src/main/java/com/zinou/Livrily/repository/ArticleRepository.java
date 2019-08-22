package com.zinou.Livrily.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zinou.Livrily.model.Produit;

@Service
public interface ArticleRepository {
	
	Produit getProduit(int id_article);
		
	Produit createProduits(Produit produit);
	
	boolean deleteProduits(int id_article);

	List<Produit> getProduits();



}
