package com.zinou.Livrily.controle;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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


	@GetMapping(value = "printFacture", produces = "application/pdf")
	public ResponseEntity<InputStreamResource> downloadPDFFile(@RequestParam int id_facture)
			throws IOException {
		return service.printFacture(id_facture);
	}

}
