package com.zinou.Livrily.model;

public class CommandeLine {

	private int CommandeLine_ID;
	private int Commande_ID;
	private int Produit_ID;
	private Double prix;
	private int quantityCommande;
	private Double totalLine;
	public int getCommandeLine_ID() {
		return CommandeLine_ID;
	}
	public void setCommandeLine_ID(int commandeLine_ID) {
		CommandeLine_ID = commandeLine_ID;
	}
	public int getCommande_ID() {
		return Commande_ID;
	}
	public void setCommande_ID(int commande_ID) {
		Commande_ID = commande_ID;
	}
	public int getProduit_ID() {
		return Produit_ID;
	}
	public void setProduit_ID(int produit_ID) {
		Produit_ID = produit_ID;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}


	public int getQuantityCommande() {
		return quantityCommande;
	}
	public void setQuantityCommande(int quantityCommande) {
		this.quantityCommande = quantityCommande;
	}
	public Double getTotalLine() {
		return totalLine;
	}
	public void setTotalLine(Double totalLine) {
		this.totalLine = totalLine;
	}







}
