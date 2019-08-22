package com.zinou.Livrily.controle;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zinou.Livrily.model.Livraisoncomplette;
import com.zinou.Livrily.service.LivraisonService;
import com.zinou.Livrily.service.LivraisonServiceImpl;

@RestController
public class LivraisonController {

	LivraisonService service = new LivraisonServiceImpl();

	@GetMapping("Livraisons")
	List<Livraisoncomplette> getLivraisons(@RequestParam(required = false) Boolean estlivre, @RequestParam(required = false) int livraison_id){
		return service.getLivraisons(estlivre, livraison_id);
	}
	@PostMapping("Livraisons")
	boolean createLivraison(@RequestParam int id_commande,@RequestParam int livreur_id){
		return service.createLivraison(id_commande, livreur_id);
	}
	

}
