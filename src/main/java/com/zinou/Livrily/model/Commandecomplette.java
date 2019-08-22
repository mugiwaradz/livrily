package com.zinou.Livrily.model;

import java.util.ArrayList;
import java.util.List;

public class Commandecomplette {
	private Commande commande;
	private	List<CommandeLine> commandelines = new ArrayList<>();
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public List<CommandeLine> getCommandelines() {
		return commandelines;
	}
	public void setCommandelines(List<CommandeLine> commandelines) {
		this.commandelines = commandelines;
	}
	
	
	
	
}
