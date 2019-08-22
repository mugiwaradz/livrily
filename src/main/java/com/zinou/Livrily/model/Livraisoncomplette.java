package com.zinou.Livrily.model;

import java.util.ArrayList;
import java.util.List;

public class Livraisoncomplette {

	private Livraison livraison;
	private	List<Livraison_Line> livraisonlines = new ArrayList<>();
	public Livraison getLivraison() {
		return livraison;
	}
	public void setLivraison(Livraison livraison) {
		this.livraison = livraison;
	}
	public List<Livraison_Line> getLivraisonlines() {
		return livraisonlines;
	}
	public void setLivraisonlines(List<Livraison_Line> livraisonlines) {
		this.livraisonlines = livraisonlines;
	}
	
	


}
