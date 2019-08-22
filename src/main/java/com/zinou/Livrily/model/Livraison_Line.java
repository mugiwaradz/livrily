package com.zinou.Livrily.model;

public class Livraison_Line {

	private int Livraison_Line_ID;
	private int Livraison_ID;
	private int Produit_ID;
	private int quantitylivre;
	private Double volume;
	public int getLivraison_Line_ID() {
		return Livraison_Line_ID;
	}
	public void setLivraison_Line_ID(int livraison_Line_ID) {
		Livraison_Line_ID = livraison_Line_ID;
	}
	public int getLivraison_ID() {
		return Livraison_ID;
	}
	public void setLivraison_ID(int livraison_ID) {
		Livraison_ID = livraison_ID;
	}
	public int getProduit_ID() {
		return Produit_ID;
	}
	public void setProduit_ID(int produit_ID) {
		Produit_ID = produit_ID;
	}
	public int getQuantitylivre() {
		return quantitylivre;
	}
	public void setQuantitylivre(int quantitylivre) {
		this.quantitylivre = quantitylivre;
	}
	public Double getVolume() {
		return volume;
	}
	public void setVolume(Double volume) {
		this.volume = volume;
	}
	
	




}
