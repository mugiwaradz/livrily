package com.zinou.Livrily.controle;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zinou.Livrily.model.Produit;
import com.zinou.Livrily.service.ArticleService;
import com.zinou.Livrily.service.ArticleServiceImpl;

@RestController
public class ArticleController {

	ArticleService service = new ArticleServiceImpl();

	@GetMapping("Article/{id_article}")
	Produit getArticles(@PathVariable( "id_article") int id_article){
		return service.getProduit(id_article);
	}

	@GetMapping("Articles")
	List<Produit> getArticles(){
		return service.getProduits();
	}
	
	@PostMapping("Article")
	Produit createArticles(@RequestBody Produit produit){
		return service.createProduits(produit);
	}

	@DeleteMapping("Article/{id_article}")
	boolean deleteArticles(@PathVariable("id_article") int id_article){
		return service.deleteProduits(id_article);
	}

}
