package com.zinou.Livrily.controle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zinou.Livrily.model.Client;
import com.zinou.Livrily.service.ArticleService;
import com.zinou.Livrily.service.ArticleServiceImpl;
import com.zinou.Livrily.service.ClientService;
import com.zinou.Livrily.service.ClientServiceImpl;

@RestController
public class ClientController {

	ClientService service = new ClientServiceImpl();

	@GetMapping("Client/{client_id}")
	Client getClient(@PathVariable( "client_id") int client_id){
		return service.getClient(client_id);
	}

	

}
