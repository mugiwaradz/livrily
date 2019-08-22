package com.zinou.Livrily.controle;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zinou.Livrily.model.Supermarché;
import com.zinou.Livrily.service.SupermarchéService;
import com.zinou.Livrily.service.SupermarchéServiceImpl;


@RestController
public class SupermarchéControleur {
	
	SupermarchéService service= new SupermarchéServiceImpl();
	
	@PostMapping("Supermarche")
	Supermarché AjouterSupermarché(@RequestBody Supermarché supermarché){
		return service.AjouterSupermarché(supermarché);
	}

	@DeleteMapping("Supermarche/{id_supermarche}")
	boolean SupprimerSupermarché(@PathVariable("id_supermarche") int id_Supermarché){
		return service.suprimerSupermarché(id_Supermarché);
	}

}
