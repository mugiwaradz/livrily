package com.zinou.Livrily.controle;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zinou.Livrily.model.Utilisateur;
import com.zinou.Livrily.service.LoginService;
import com.zinou.Livrily.service.LoginServiceImpl;

@RestController
public class LoginController {

	LoginService service = new LoginServiceImpl();



	@PostMapping("Login")
	boolean Login(@RequestBody Utilisateur utilisateur){
		return service.Login(utilisateur);
	}

}
