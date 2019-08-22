package com.zinou.Livrily.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zinou.Livrily.model.Commande;
import com.zinou.Livrily.model.CommandeLine;
import com.zinou.Livrily.model.Commandecomplette;

@Service
public interface CommandeRepository {

	List<Commandecomplette> getCommandes(Timestamp date_commande, int id_commande);

	CommandeLine saveCommandeLine(CommandeLine line);

	void updateCommande(Double prixTotal, int commande_ID);

	Commande saveCommande(Commande commande);
	
	


}
