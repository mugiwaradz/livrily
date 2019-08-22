package com.zinou.Livrily.controle;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zinou.Livrily.model.Full_User;
import com.zinou.Livrily.service.UtilisateurServiceImpl;
import com.zinou.Livrily.service.UtilisateureService;

@RestController
public class UtilisateurController {

	UtilisateureService service = new UtilisateurServiceImpl();


	@GetMapping("Utilisateur")
	List<Full_User> getUtilisateurs(@RequestParam int type_user, @RequestParam(required = false) String id_utilisateur){
		return service.getutilisateurs(type_user,
				(id_utilisateur != null && id_utilisateur.length() > 0) ? Integer.parseInt(id_utilisateur) : -1);
	}
	
	@PostMapping("Utilisateur")
	Full_User createUtilisateurs(@RequestBody Full_User full_user){
		return service.createutilisateurs(full_user);
	}

	@DeleteMapping("Utilisateur/{id_utilisateur}")
	boolean deleteUtilisateurs(@PathVariable("id_utilisateur") int id_utilisateur){
		return service.deleteUtilisateurs(id_utilisateur);
	}
}
