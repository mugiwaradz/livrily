package com.zinou.Livrily.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zinou.Livrily.model.Produit;
import com.zinou.Livrily.repository.ArticleRepository;

public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticleRepository repository;
	
	@Override
	public Produit getProduit(int id_article) {
		return repository.getProduit(id_article);
	}

	@Override
	public Produit createProduits(Produit produit) {
		return repository.createProduits(produit);
	}

	@Override
	public boolean deleteProduits(int id_article) {
		return repository.deleteProduits(id_article);
	}

	@Override
	public List<Produit> getProduits() {
		return repository.getProduits();
	}	
}
