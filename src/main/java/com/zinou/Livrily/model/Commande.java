package com.zinou.Livrily.model;

import java.sql.Timestamp;

public class Commande {

	private int Commande_ID;
	private int Supermarché_ID;
	private int Clinet_ID;
	private Timestamp DtaedeCommande;
	private String Statue;
	private int NumeroCommande;
	private Double total;
	private String tarif;
	private int tva;
	public int getCommande_ID() {
		return Commande_ID;
	}
	public void setCommande_ID(int commande_ID) {
		Commande_ID = commande_ID;
	}
	public int getSupermarché_ID() {
		return Supermarché_ID;
	}
	public void setSupermarché_ID(int supermarché_ID) {
		Supermarché_ID = supermarché_ID;
	}
	public int getClinet_ID() {
		return Clinet_ID;
	}
	public void setClinet_ID(int clinet_ID) {
		Clinet_ID = clinet_ID;
	}
	public Timestamp getDtaedeCommande() {
		return DtaedeCommande;
	}
	public void setDtaedeCommande(Timestamp dtaedeCommande) {
		DtaedeCommande = dtaedeCommande;
	}
	public String getStatue() {
		return Statue;
	}
	public void setStatue(String statue) {
		Statue = statue;
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
	public int getNumeroCommande() {
		return NumeroCommande;
	}
	public void setNumeroCommande(int numeroCommande) {
		NumeroCommande = numeroCommande;
	}


	




}
