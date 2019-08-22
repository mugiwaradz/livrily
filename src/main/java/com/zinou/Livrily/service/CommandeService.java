package com.zinou.Livrily.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zinou.Livrily.model.CommandeSimple;
import com.zinou.Livrily.model.Commandecomplette;

@Service
public interface CommandeService {

	List<Commandecomplette> getCommandes(Timestamp date_commande, int commande_id);
	
	Commandecomplette createCommandes(List<CommandeSimple> commandes);

	
}
