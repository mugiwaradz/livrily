package com.zinou.Livrily.service;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zinou.Livrily.model.CommandeLine;
import com.zinou.Livrily.model.Commandecomplette;
import com.zinou.Livrily.model.Facture;
import com.zinou.Livrily.model.FactureLine;
import com.zinou.Livrily.model.Facturecomplette;
import com.zinou.Livrily.model.Livraisoncomplette;
import com.zinou.Livrily.repository.FactureRepository;
import com.zinou.Livrily.repository.FactureRepositoryImpl;

@Service
public class FactureServiceImpl implements FactureService{


	FactureRepository repository=new FactureRepositoryImpl();

	LivraisonService livraisonService= new LivraisonServiceImpl();
	
	CommandeService commandeService= new CommandeServiceImpl();


			@Override
			public List<Facturecomplette> getFactures() {
		return repository.getFactures();
	}

	@Override
	public boolean createFacture(int id_livraison) {

		Livraisoncomplette livraison = livraisonService.getLivraisons(null, id_livraison).get(0);
		Commandecomplette commande = commandeService.getCommandes(null, livraison.getLivraison().getCommande_ID()).get(0);


		Facture facture = new Facture();
		facture.setLivraison_ID(livraison.getLivraison().getLivraison_ID());
		String numeroComande = livraison.getLivraison().getNumeroLivraison().replace("Ship_", "");
		numeroComande = "Fact_" + numeroComande;
		facture.setNumeroFacture(numeroComande );
		facture.setClient_ID(commande.getCommande().getClinet_ID());
		facture.setTarif(commande.getCommande().getTarif());
		facture.setTva(commande.getCommande().getTva());
		
		facture = repository.createFacture(facture);
		

		Double total = 0.0;

		for (CommandeLine line : commande.getCommandelines()) {
			FactureLine fLine = new FactureLine();
			fLine.setFacture_ID(facture.getFacture_ID());
			fLine.setProduitID(line.getProduit_ID());
			fLine.setQuantityFacture(line.getQuantityCommande());
			fLine.setPrix(line.getPrix());
			fLine.setTotalLine(line.getTotalLine());
			fLine = repository.createFactureLine(fLine);
			total = total + fLine.getTotalLine();
		}

		repository.updateFacture(total, facture.getFacture_ID());

		return true;
	}

	@Override
	public File printFacture(int id_article) {
		// TODO print with Ireport
		return null;
	}

}