package com.zinou.Livrily.controle;

import java.io.File;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zinou.Livrily.model.Facturecomplette;
import com.zinou.Livrily.service.FactureService;
import com.zinou.Livrily.service.FactureServiceImpl;

@RestController
public class FactureController {

	FactureService service = new FactureServiceImpl();

	@GetMapping("Factures")
	List<Facturecomplette> getFactures(){
		return service.getFactures();
	}
	
	@PostMapping("Factures")
	boolean createFacture(@RequestParam int id_livraison){
		return service.createFacture(id_livraison);
	}
	

	@GetMapping("Facture/{id_facture}")
	File getArticles(@PathVariable( "id_facture") int id_facture){
		return service.printFacture(id_facture);
	}
	
}
