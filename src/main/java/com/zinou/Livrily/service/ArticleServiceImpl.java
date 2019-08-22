package com.zinou.Livrily.service;

import java.util.List;

import com.zinou.Livrily.model.Produit;
import com.zinou.Livrily.repository.ArticleRepository;
import com.zinou.Livrily.repository.ArticleRepositoryImpl;

public class ArticleServiceImpl implements ArticleService {

	
	ArticleRepository repository = new ArticleRepositoryImpl();
	
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
