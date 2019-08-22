package com.zinou.Livrily.model;

public class Fournisseur {
	
	private int Fournisseur_ID;
	private int Utilisateur_ID;
	private int numeroGestire;
	private int numeroFiscale;
	private String taxid;
	public int getFournisseur_ID() {
		return Fournisseur_ID;
	}
	public void setFournisseur_ID(int fournisseur_ID) {
		Fournisseur_ID = fournisseur_ID;
	}
	public int getUtilisateur_ID() {
		return Utilisateur_ID;
	}
	public void setUtilisateur_ID(int utilisateur_ID) {
		Utilisateur_ID = utilisateur_ID;
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
	
	
	
	


}
