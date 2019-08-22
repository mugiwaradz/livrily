package com.zinou.Livrily.model;

public class Produit {

	private int Produit_ID;
	private String NomProduit;
	private int CategoréProduit_ID;
	private Double PrixDachat;
	private Double PrixDevante;
	private int Fournisseur_ID;
	private String Image;
	private String Referance;
	private int promotion=0;	
	
	
	public int getPromotion() {
		return promotion;
	}
	public void setPromotion(int promotion) {
		this.promotion = promotion;
	}
	public int getProduit_ID() {
		return Produit_ID;
	}
	public void setProduit_ID(int produit_ID) {
		Produit_ID = produit_ID;
	}
	public String getNomProduit() {
		return NomProduit;
	}
	public void setNomProduit(String nomProduit) {
		NomProduit = nomProduit;
	}
	public int getCategoréProduit_ID() {
		return CategoréProduit_ID;
	}
	public void setCategoréProduit_ID(int categoréProduit_ID) {
		CategoréProduit_ID = categoréProduit_ID;
	}
	public Double getPrixDachat() {
		return PrixDachat;
	}
	public void setPrixDachat(Double prixDachat) {
		PrixDachat = prixDachat;
	}
	public Double getPrixDevante() {
		return PrixDevante;
	}
	public void setPrixDevante(Double prixDevante) {
		PrixDevante = prixDevante;
	}
	public int getFournisseur_ID() {
		return Fournisseur_ID;
	}
	public void setFournisseur_ID(int fournisseur_ID) {
		Fournisseur_ID = fournisseur_ID;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getReferance() {
		return Referance;
	}
	public void setReferance(String referance) {
		Referance = referance;
	}












}
