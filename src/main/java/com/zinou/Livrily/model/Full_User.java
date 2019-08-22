package com.zinou.Livrily.model;

public class Full_User {
	private int type_user;
	private Utilisateur utilisateur;
	private int NumCarteCredit;
	private String tarif;
	private boolean envoyerMail;
	private boolean envoyerSMS;
	private int numeroGestire;
	private int numeroFiscale;
	private String taxid;
	private String moyenLivraison;
	private String typePermetConduire;
	private int distanceMax;
	private boolean est_disponible;
	private int supermarché_ID;
	private int client_ID;
	private int livreur_ID;
	private int fournisseur_ID;
	

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public int getNumCarteCredit() {
		return NumCarteCredit;
	}
	public void setNumCarteCredit(int numCarteCredit) {
		NumCarteCredit = numCarteCredit;
	}
	public String getTarif() {
		return tarif;
	}
	public void setTarif(String tarif) {
		this.tarif = tarif;
	}
	public boolean isEnvoyerMail() {
		return envoyerMail;
	}
	public void setEnvoyerMail(boolean envoyerMail) {
		this.envoyerMail = envoyerMail;
	}
	public boolean isEnvoyerSMS() {
		return envoyerSMS;
	}
	public void setEnvoyerSMS(boolean envoyerSMS) {
		this.envoyerSMS = envoyerSMS;
	}
	public int getNumeroGestire() {
		return numeroGestire;
	}
	public void setNumeroGestire(int numeroGestire) {
		this.numeroGestire = numeroGestire;
	}
	public int getNumeroFiscale() {
		return numeroFiscale;
	}
	public void setNumeroFiscale(int numeroFiscale) {
		this.numeroFiscale = numeroFiscale;
	}
	public String getTaxid() {
		return taxid;
	}
	public void setTaxid(String taxid) {
		this.taxid = taxid;
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
	public int getSupermarché_ID() {
		return supermarché_ID;
	}
	public void setSupermarché_ID(int supermarché_ID) {
		this.supermarché_ID = supermarché_ID;
	}
	public int getType_user() {
		return type_user;
	}
	public void setType_user(int type_user) {
		this.type_user = type_user;
	}
	public int getClient_ID() {
		return client_ID;
	}
	public void setClient_ID(int client_ID) {
		this.client_ID = client_ID;
	}
	public int getLivreur_ID() {
		return livreur_ID;
	}
	public void setLivreur_ID(int livreur_ID) {
		this.livreur_ID = livreur_ID;
	}
	public int getFournisseur_ID() {
		return fournisseur_ID;
	}
	public void setFournisseur_ID(int fournisseur_ID) {
		this.fournisseur_ID = fournisseur_ID;
	}

}
