package com.zinou.Livrily.model;

public class Livreur {

	private int Livreur_ID;
	private int supermarché_ID;
	private int utilisateur_ID;
	private String moyenLivraison;
	private String typePermetConduire;
	private int distanceMax;
	private boolean est_disponible;

	public int getLivreur_ID() {
		return Livreur_ID;
	}
	public void setLivreur_ID(int livreur_ID) {
		Livreur_ID = livreur_ID;
	}
	public int getSupermarché_ID() {
		return supermarché_ID;
	}
	public void setSupermarché_ID(int supermarché_ID) {
		this.supermarché_ID = supermarché_ID;
	}
	public int getUtilisateur_ID() {
		return utilisateur_ID;
	}
	public void setUtilisateur_ID(int utilisateur_ID) {
		this.utilisateur_ID = utilisateur_ID;
	}
	public String getMoyenLivraison() {
		return moyenLivraison;
	}
	public void setMoyenLivraison(String moyenLivraison) {
		this.moyenLivraison = moyenLivraison;
	}
	public String getTypePermetConduire() {
		return typePermetConduire;
	}
	public void setTypePermetConduire(String typePermetConduire) {
		this.typePermetConduire = typePermetConduire;
	}
	public int getDistanceMax() {
		return distanceMax;
	}
	public void setDistanceMax(int distanceMax) {
		this.distanceMax = distanceMax;
	}
	public boolean isEst_disponible() {
		return est_disponible;
	}
	public void setEst_disponible(boolean est_disponible) {
		this.est_disponible = est_disponible;
	}
	
	





}
