package com.zinou.Livrily.model;

public class FactureLine {

	private int FactureLine_ID;
	private int Facture_ID;
	private int produitID;
	private Double prix;
	private int quantityFacture;
	private Double totalLine;
	public int getFactureLine_ID() {
		return FactureLine_ID;
	}
	public void setFactureLine_ID(int factureLine_ID) {
		FactureLine_ID = factureLine_ID;
	}
	public int getFacture_ID() {
		return Facture_ID;
	}
	public void setFacture_ID(int facture_ID) {
		Facture_ID = facture_ID;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public int getQuantityFacture() {
		return quantityFacture;
	}
	public void setQuantityFacture(int quantityFacture) {
		this.quantityFacture = quantityFacture;
	}
	public Double getTotalLine() {
		return totalLine;
	}
	public void setTotalLine(Double totalLine) {
		this.totalLine = totalLine;
	}
	public int getProduitID() {
		return produitID;
	}
	public void setProduitID(int produitID) {
		this.produitID = produitID;
	}
	
	
	
	

	
}
