package com.zinou.Livrily.model;

public class Facture {
	
	private int Facture_ID;
	private int Livraison_ID;
	private int Client_ID;
	private String NumeroFacture;
	private Double total;
	private String tarif;
	private int tva;
	public int getFacture_ID() {
		return Facture_ID;
	}
	public void setFacture_ID(int facture_ID) {
		Facture_ID = facture_ID;
	}
	public int getLivraison_ID() {
		return Livraison_ID;
	}
	public void setLivraison_ID(int livraison_ID) {
		Livraison_ID = livraison_ID;
	}
	public int getClient_ID() {
		return Client_ID;
	}
	public void setClient_ID(int client_ID) {
		Client_ID = client_ID;
	}
	public String getNumeroFacture() {
		return NumeroFacture;
	}
	public void setNumeroFacture(String numeroFacture) {
		NumeroFacture = numeroFacture;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getTarif() {
		return tarif;
	}
	public void setTarif(String tarif) {
		this.tarif = tarif;
	}
	public int getTva() {
		return tva;
	}
	public void setTva(int tva) {
		this.tva = tva;
	}
	
	
	
	


}
