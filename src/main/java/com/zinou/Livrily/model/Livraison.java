package com.zinou.Livrily.model;

public class Livraison {
	
	private int Livraison_ID;
	private int Commande_ID;
	private int Livreur_ID;
	private String NumeroLivraison;
	private int volumneTotal;
	private boolean estLivre;
	public int getLivraison_ID() {
		return Livraison_ID;
	}
	public void setLivraison_ID(int livraison_ID) {
		Livraison_ID = livraison_ID;
	}
	public int getCommande_ID() {
		return Commande_ID;
	}
	public void setCommande_ID(int commande_ID) {
		Commande_ID = commande_ID;
	}
	public int getLivreur_ID() {
		return Livreur_ID;
	}
	public void setLivreur_ID(int livreur_ID) {
		Livreur_ID = livreur_ID;
	}
	public String getNumeroLivraison() {
		return NumeroLivraison;
	}
	public void setNumeroLivraison(String numeroLivraison) {
		NumeroLivraison = numeroLivraison;
	}
	public int getVolumneTotal() {
		return volumneTotal;
	}
	public void setVolumneTotal(int volumneTotal) {
		this.volumneTotal = volumneTotal;
	}
	public boolean isEstLivre() {
		return estLivre;
	}
	public void setEstLivre(boolean estLivre) {
		this.estLivre = estLivre;
	}
	
	
	
	
	

	


}
