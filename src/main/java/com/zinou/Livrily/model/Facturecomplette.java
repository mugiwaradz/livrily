package com.zinou.Livrily.model;

import java.util.ArrayList;
import java.util.List;

public class Facturecomplette {
	private Facture facture;
	private	List<FactureLine> facturelines = new ArrayList<>();
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	public List<FactureLine> getFacturelines() {
		return facturelines;
	}
	public void setFacturelines(List<FactureLine> facturelines) {
		this.facturelines = facturelines;
	}
	
	
	
	
}
