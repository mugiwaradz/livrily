package com.zinou.Livrily.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zinou.Livrily.model.Client;
import com.zinou.Livrily.model.Commande;
import com.zinou.Livrily.model.CommandeLine;
import com.zinou.Livrily.model.CommandeSimple;
import com.zinou.Livrily.model.Commandecomplette;
import com.zinou.Livrily.model.Produit;
import com.zinou.Livrily.repository.CommandeRepository;
import com.zinou.Livrily.repository.CommandeRepositoryImpl;

@Service
public class CommandeServiceImpl implements CommandeService {


	CommandeRepository repository= new CommandeRepositoryImpl();
	ClientService clientService = new ClientServiceImpl();
	ArticleService articleService = new ArticleServiceImpl();


	@Override
	public List<Commandecomplette> getCommandes(Timestamp date_commande, int id_commande) {
		return 	 repository.getCommandes(date_commande, id_commande);
	}

	@Override
	public Commandecomplette createCommandes(List<CommandeSimple> commandes) {

		Client client = clientService.getClient(commandes.get(0).getClient_id());

		Commandecomplette commandeComplete = new Commandecomplette();
		Commande commande = new Commande();
		commande.setClinet_ID(client.getClient_ID());
		commande.setDtaedeCommande(new Timestamp(System.currentTimeMillis()));
		commande.setStatue("Brouillon"); //TODO
		commande.setSupermarché_ID(commandes.get(0).getSuperMarche_id());
		commande.setTarif(client.getTarif());
		commande.setTva(17);

		commandeComplete.setCommande(commande);

		commande = repository.saveCommande(commande);

		Double prixTotal = 0.0;

		List<CommandeLine> lines = new ArrayList<>();

		for (CommandeSimple c : commandes) {

			Produit produit =  articleService.getProduit(c.getProduit_id());
			CommandeLine line = new CommandeLine();
			line.setCommande_ID(commande.getCommande_ID());
			line.setPrix(produit.getPrixDevante());
			line.setProduit_ID(produit.getProduit_ID());
			line.setQuantityCommande(c.getQtyCommande());
			line.setTotalLine(line.getQuantityCommande() * line.getPrix());
			prixTotal = prixTotal + line.getTotalLine();

			line = repository.saveCommandeLine(line);

			lines.add(line);

		}

		commandeComplete.setCommandelines(lines);

		repository.updateCommande(prixTotal, commande.getCommande_ID());

		return commandeComplete;
	}

}




