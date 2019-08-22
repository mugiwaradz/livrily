package com.zinou.Livrily.controle;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zinou.Livrily.model.Produit;
import com.zinou.Livrily.service.PromotionsService;
import com.zinou.Livrily.service.PromotionsServiceImpl;

@RestController
public class PromotionsController {

	PromotionsService service = new PromotionsServiceImpl();

	@GetMapping("promotion")
	List<Produit> getPromotion(@RequestParam int categorie_produit_id){
		return service.getPromotion(categorie_produit_id);
				
	}


	@PostMapping("promotion")
	int PostPromotion(@RequestBody Produit produit){
		return service.PostPromotion(produit);
	}

}
