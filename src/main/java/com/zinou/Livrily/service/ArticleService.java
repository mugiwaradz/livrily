package com.zinou.Livrily.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zinou.Livrily.model.Produit;

@Service
public interface ArticleService {
	
	Produit getProduit(int id_article);
	
	List<Produit> getProduits();
	
	Produit createProduits(Produit produit);
	
	boolean deleteProduits(int id_article);

}
