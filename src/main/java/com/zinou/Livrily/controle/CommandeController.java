package com.zinou.Livrily.controle;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zinou.Livrily.model.CommandeSimple;
import com.zinou.Livrily.model.Commandecomplette;
import com.zinou.Livrily.service.CommandeService;
import com.zinou.Livrily.service.CommandeServiceImpl;

@RestController
public class CommandeController {

	CommandeService service = new CommandeServiceImpl();

	@GetMapping("Commandes")
	List<Commandecomplette> getCommandes( @RequestParam(required = false) Timestamp date_commande,
			@RequestParam(required = false) int id_commande) {
		return service.getCommandes(date_commande, id_commande);
	}
	
	@PostMapping("Commandes")
	Commandecomplette getCommandes( @RequestBody List <CommandeSimple> commandes) {
		return service.createCommandes(commandes);
	}

}
